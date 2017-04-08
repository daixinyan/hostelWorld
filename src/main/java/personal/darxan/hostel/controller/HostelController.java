package personal.darxan.hostel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import personal.darxan.hostel.service.impl.HostelServiceImpl;
import personal.darxan.hostel.service.interf.AuthService;
import personal.darxan.hostel.service.interf.HostelService;
import personal.darxan.hostel.service.interf.OrderService;
import personal.darxan.hostel.tool.AttributeUpdate;
import personal.darxan.hostel.tool.DateFormatter;
import personal.darxan.hostel.tool.MyLogger;
import personal.darxan.hostel.tool.MyPair;
import personal.darxan.hostel.vo.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by darxan on 2017/2/14.
 */
@Controller
@RequestMapping(value = "/hostel")
public class HostelController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private HostelService hostelService = new HostelServiceImpl();

    @Autowired
    private AuthService authService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(DateFormatter.dateFormat, false));
    }


    @ResponseBody
    @RequestMapping(value = "/increment/{roomId}/{count}")
    public ServiceResult scheduleIncrement(HttpServletRequest httpServletRequest,
                                          @PathVariable("roomId") Long roomId,
                                          @PathVariable("count") int count) {
        return hostelService.scheduleIncrement(httpServletRequest, roomId, count);
    }

    @RequestMapping(value = "/list/schedule")
    public ModelAndView schedule(HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        ServiceResult serviceResult =
                hostelService.schedule(httpServletRequest);
        modelAndView.setViewName("/hostel/schedule");
        MyPair<HostelVO, List<HostelRoomVO>> pair =
                (MyPair<HostelVO, List<HostelRoomVO>>) serviceResult.getValue();
        modelAndView.addObject("hostel", pair.getFirst());
        modelAndView.addObject("rooms",  pair.getSecond());
        return modelAndView;
    }

    @RequestMapping(value = "/update/schedule")
    public ModelAndView updateSchedule(HttpServletRequest httpServletRequest,
                                       @ModelAttribute HostelRoomVO hostelRoomVO) {
        MyLogger.log("hostelRoomVO");
        MyLogger.log(hostelRoomVO);
        ModelAndView modelAndView = new ModelAndView();
        ServiceResult serviceResult =
                hostelService.updateSchedule(httpServletRequest, hostelRoomVO);
        modelAndView.setViewName("redirect: /hostel/list/schedule");
        modelAndView.addObject("result",serviceResult.isSuccess());
        return modelAndView;
    }

    @RequestMapping(value = "/action/schedule")
    public ModelAndView addSchedule(HttpServletRequest httpServletRequest,
                                     @ModelAttribute HostelRoomVO hostelRoomVO) {
        MyLogger.log("hostelRoomVO");
        MyLogger.log(hostelRoomVO);
        ModelAndView modelAndView = new ModelAndView("redirect: /hostel/list/schedule");
        ServiceResult serviceResult = hostelService.addSchedule(httpServletRequest, hostelRoomVO);
        modelAndView.addObject("message", serviceResult.getMessage());
        return modelAndView;
    }

    @RequestMapping(value = "/hostel/info")
    public ModelAndView hostel(HttpServletRequest httpServletRequest,
                                      @ModelAttribute HostelVO hostel) {
        ModelAndView modelAndView = new ModelAndView();

        ServiceResult serviceResult = authService.getCurrentLogin(httpServletRequest);

        MyLogger.log(serviceResult);

        if (serviceResult.isSuccess() && serviceResult.getValue() instanceof HostelVO) {
            modelAndView.setViewName("/hostel/hostel");
            modelAndView.addObject("hostel", (HostelVO)serviceResult.getValue());
        }else {
            modelAndView.setViewName("public/login");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/update/info")
    public ModelAndView update(HttpServletRequest httpServletRequest,
                                      @ModelAttribute HostelVO hostel) {

        MyLogger.log(hostel);

        ServiceResult serviceResult = hostelService.updateHostel(httpServletRequest, hostel);

        MyLogger.log(serviceResult);

        ModelAndView modelAndView = new ModelAndView("/hostel/hostel");
        modelAndView.addObject("hostel", serviceResult.getValue());
        modelAndView.addObject("message", serviceResult.getMessage());
        return modelAndView;
    }
    @RequestMapping(value = "/state/active")
    public ModelAndView active(HttpServletRequest httpServletRequest) {

        ModelAndView modelAndView = new ModelAndView("redirect: /hostel/hostel/info");
        ServiceResult serviceResult = hostelService.state(httpServletRequest, (short) 1);
        modelAndView.addObject("result",serviceResult);
        return modelAndView;
    }

    @RequestMapping(value = "/state/delete")
    public ModelAndView delete(HttpServletRequest httpServletRequest) {

        ModelAndView modelAndView = new ModelAndView("redirect: /");
        ServiceResult serviceResult = hostelService.state(httpServletRequest, (short) -1);
        return modelAndView;
    }


    @RequestMapping(value = "/action/checkIn")
    @ResponseBody
    public ServiceResult checkIn(HttpServletRequest httpServletRequest,
                                 @ModelAttribute CheckIn checkIn) {
        return orderService.checkIn(checkIn, httpServletRequest);
    }

    @RequestMapping(value = "/action/checkOut")
    @ResponseBody
    public ServiceResult checkOut(HttpServletRequest httpServletRequest,
                                  @ModelAttribute CheckOut checkOut) {
        return orderService.checkOut(checkOut, httpServletRequest);
    }


    @RequestMapping(value = "/list/reservation")
    @ResponseBody
    public ModelAndView getReservation(HttpServletRequest httpServletRequest,
                                        @ModelAttribute ReservationRestrict reservationRestrict) {
        MyLogger.log(reservationRestrict);
        AttributeUpdate.clearObject(reservationRestrict, ReservationRestrict.class);

        ModelAndView modelAndView = new ModelAndView();
        ServiceResult serviceResult = orderService.getReservationByHostel(
                httpServletRequest, reservationRestrict);
        modelAndView.setViewName("hostel/reserved");
        modelAndView.addObject("paginationResult", (PaginationResult)serviceResult.getValue());
        modelAndView.addObject("reservationRestrict", reservationRestrict);
        
        MyLogger.log(serviceResult);
        return modelAndView;
    }

    @RequestMapping(value = "/list/checkIn")
    public ModelAndView getCheckIn(HttpServletRequest httpServletRequest,
                                    @ModelAttribute ReservationRestrict reservationRestrict) {
        MyLogger.log(reservationRestrict);
        AttributeUpdate.clearObject(reservationRestrict, ReservationRestrict.class);

        ModelAndView modelAndView = new ModelAndView();
        ServiceResult serviceResult = orderService.getCheckInByHostel(
                httpServletRequest, reservationRestrict);
        modelAndView.setViewName("hostel/checkIn");
        modelAndView.addObject("paginationResult", (PaginationResult)serviceResult.getValue());
        modelAndView.addObject("reservationRestrict", reservationRestrict);
        modelAndView.addObject("reservation", (ReservationShowHostel)null);
        MyLogger.log(serviceResult);
        return modelAndView;
    }



    @RequestMapping(value = "/list/payment")
    public ModelAndView getPayment(HttpServletRequest httpServletRequest,
                                    @ModelAttribute ReservationRestrict reservationRestrict) {

        MyLogger.log(reservationRestrict);
        AttributeUpdate.clearObject(reservationRestrict, ReservationRestrict.class);

        ModelAndView modelAndView = new ModelAndView();
        ServiceResult serviceResult = orderService.getPaymentByHostel(
                httpServletRequest, reservationRestrict);

        MyLogger.log(serviceResult);

        modelAndView.setViewName("hostel/payment");
        modelAndView.addObject("paginationResult", (PaginationResult)serviceResult.getValue());
        modelAndView.addObject("reservationRestrict", reservationRestrict);
        modelAndView.addObject("reservation", (ReservationShowHostel)null);
        return modelAndView;
    }


}
