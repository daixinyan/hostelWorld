package personal.darxan.hostel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import personal.darxan.hostel.service.interf.AuthService;
import personal.darxan.hostel.service.interf.OrderService;
import personal.darxan.hostel.service.interf.UserService;
import personal.darxan.hostel.tool.MyLogger;
import personal.darxan.hostel.vo.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by darxan on 2017/2/14.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    public ServiceResult deposit() {
        ServiceResult modelAndView = new ServiceResult();
        return modelAndView;
    }

    @RequestMapping(value = "/user/info")
    public ModelAndView user(HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();

        ServiceResult serviceResult = authService.getCurrentLogin(httpServletRequest);

        MyLogger.log(serviceResult);

        if (serviceResult.isSuccess() && serviceResult.getValue() instanceof MemberVO) {
            modelAndView.setViewName("/user/user");
            modelAndView.addObject("user", serviceResult.getValue());
        }else {
            modelAndView.setViewName("public/login");
        }
        return modelAndView;

    }

    @RequestMapping(value = "/cancel/{reservationId}")
    @ResponseBody
    public ServiceResult cancel(HttpServletRequest httpServletRequest,
                                @PathVariable("reservationId") Long reservationId) {
        ServiceResult serviceResult =
                orderService.cancel(reservationId, httpServletRequest);
        return serviceResult;
    }

    @RequestMapping(value = "/reserve")
    public ServiceResult reserve(HttpServletRequest httpServletRequest,
                                 @ModelAttribute ReservationVO reservationVO) {
        ServiceResult serviceResult =
                orderService.reserve(reservationVO, httpServletRequest);
        return serviceResult;
    }


    @RequestMapping(value = "/list/reservation")
    public ModelAndView getReservation(HttpServletRequest httpServletRequest,
                                        @ModelAttribute ReservationRestrict reservationRestrict) {


        MyLogger.log(reservationRestrict);
        ModelAndView modelAndView = new ModelAndView();
        ServiceResult serviceResult =
                orderService.getReservationByUser(httpServletRequest, reservationRestrict);


        MyLogger.log(serviceResult);

        modelAndView.setViewName("user/payment");
        modelAndView.addObject("paginationResult", (PaginationResult)serviceResult.getValue());
        modelAndView.addObject("reservationRestrict", reservationRestrict);
        modelAndView.addObject("reservation", (ReservationShowMember)null);
        return modelAndView;
    }

    @RequestMapping(value = "/list/checkIn")
    public ModelAndView getCheckIn(HttpServletRequest httpServletRequest,
                                    @ModelAttribute ReservationRestrict reservationRestrict) {
        MyLogger.log(reservationRestrict);
        ModelAndView modelAndView = new ModelAndView();
        ServiceResult serviceResult =
                orderService.getCheckInByUser(httpServletRequest, reservationRestrict);


        MyLogger.log(serviceResult);

        modelAndView.setViewName("user/checkIn");
        modelAndView.addObject("paginationResult", (PaginationResult)serviceResult.getValue());
        modelAndView.addObject("reservationRestrict", reservationRestrict);
        modelAndView.addObject("reservation", (ReservationShowMember)null);
        return modelAndView;
    }


    @RequestMapping(value = "/list/payment")
    public ModelAndView getPayment(HttpServletRequest httpServletRequest,
                                    @ModelAttribute ReservationRestrict reservationRestrict) {
        MyLogger.log(reservationRestrict);
        ModelAndView modelAndView = new ModelAndView();
        ServiceResult serviceResult =
                orderService.getPaymentByUser(httpServletRequest, reservationRestrict);


        MyLogger.log(serviceResult);

        modelAndView.setViewName("user/payment");
        modelAndView.addObject("paginationResult", (PaginationResult)serviceResult.getValue());
        modelAndView.addObject("reservationRestrict", reservationRestrict);
        modelAndView.addObject("reservation", (ReservationShowMember)null);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/level")
    public ServiceResult level(HttpServletRequest httpServletRequest) {

        ServiceResult serviceResult = userService.level(httpServletRequest);
        return serviceResult;
    }

    @ResponseBody
    @RequestMapping(value = "/exchange/{bonusPoint}")
    public ServiceResult exchange(HttpServletRequest httpServletRequest,
                                  @PathVariable("bonusPoint") long bonusPoint) {
        ServiceResult serviceResult =
                userService.exchange(httpServletRequest, bonusPoint);
        return serviceResult;
    }


    @RequestMapping(value = "/update")
    public ModelAndView updateInformation(@ModelAttribute MemberVO member,
                                          HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/user");
        ServiceResult serviceResult = userService.updateInformation(httpServletRequest, member);
        modelAndView.addObject("user", serviceResult.getValue());
        modelAndView.addObject("message", serviceResult.getMessage());
        return modelAndView;
    }

}
