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
import personal.darxan.hostel.tool.MyLogger;
import personal.darxan.hostel.vo.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
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
        modelAndView.addObject("schedules",serviceResult.getValue());
        return modelAndView;
    }

    @RequestMapping(value = "/update/schedule")
    public ModelAndView updateSchedule(HttpServletRequest httpServletRequest,
                                       @ModelAttribute HostelRoomVO hostelRoomVO) {
        ModelAndView modelAndView = new ModelAndView();
        ServiceResult serviceResult =
                hostelService.updateSchedule(httpServletRequest, hostelRoomVO);
        modelAndView.setViewName("redirect: /list/schedule");
        modelAndView.addObject("result",serviceResult.isSuccess());
        return modelAndView;
    }

    @RequestMapping(value = "/action/schedule")
    @ResponseBody
    public ServiceResult addSchedule(HttpServletRequest httpServletRequest,
                                     @ModelAttribute HostelRoomVO hostelRoomVO) {
        MyLogger.log("hostelRoomVO");
        MyLogger.log(hostelRoomVO);
        return hostelService.addSchedule(httpServletRequest, hostelRoomVO);
    }

    @RequestMapping(value = "/hostel/info")
    public ModelAndView hostel(HttpServletRequest httpServletRequest,
                                      @ModelAttribute HostelVO hostel) {
        ModelAndView modelAndView = new ModelAndView();

        ServiceResult serviceResult = authService.getCurrentLogin(httpServletRequest);

        MyLogger.log(serviceResult);

        if (serviceResult.isSuccess() && serviceResult.getValue() instanceof HostelVO) {
            modelAndView.setViewName("/hostel/hostel");
            modelAndView.addObject("hostel", serviceResult.getValue());
        }else {
            modelAndView.setViewName("public/login");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/update")
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

    @RequestMapping(value = "/checkIn")
    @ResponseBody
    public ServiceResult checkIn(HttpServletRequest httpServletRequest,
                                 @ModelAttribute CheckIn checkIn) {
        return orderService.checkIn(checkIn, httpServletRequest);
    }

    @RequestMapping(value = "/checkOut")
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
        ModelAndView modelAndView = new ModelAndView();
        ServiceResult serviceResult = orderService.getReservationByHostel(
                httpServletRequest, reservationRestrict);
        modelAndView.setViewName("/hostel/reservation");
        modelAndView.addObject("paginationResult", (PaginationResult)serviceResult.getValue());
        modelAndView.addObject("reservationRestrict", reservationRestrict);
        modelAndView.addObject("reservation", (ReservationShowHostel)null);
        MyLogger.log(serviceResult);
        return modelAndView;
    }

    @RequestMapping(value = "/list/checkIn")
    public ModelAndView getCheckIn(HttpServletRequest httpServletRequest,
                                    @ModelAttribute ReservationRestrict reservationRestrict) {
        MyLogger.log(reservationRestrict);
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
