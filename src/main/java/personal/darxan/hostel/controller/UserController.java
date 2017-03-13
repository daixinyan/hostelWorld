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
import personal.darxan.hostel.tool.AttributeUpdate;
import personal.darxan.hostel.tool.DateFormatter;
import personal.darxan.hostel.tool.MyLogger;
import personal.darxan.hostel.vo.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by darxan on 2017/2/14.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {


    AtomicIntegerArray atomicIntegerArray;
    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;



    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(DateFormatter.dateFormat, false));

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
            modelAndView.addObject("user", (MemberVO)serviceResult.getValue());
        }else {
            modelAndView.setViewName("public/login");
        }
        return modelAndView;

    }

    @RequestMapping(value = "/cancel/{reservationId}")
    public ModelAndView cancel(HttpServletRequest httpServletRequest,
                                @PathVariable("reservationId") Long reservationId) {
        ModelAndView modelAndView = new ModelAndView("redirect: /user/list/reservation");
        ServiceResult serviceResult =
                orderService.cancel(reservationId, httpServletRequest);
        modelAndView.addObject("result",serviceResult);
        return modelAndView;
    }

    @RequestMapping(value = "/reserve/default")
    public ModelAndView reserve(HttpServletRequest httpServletRequest,
                                 @ModelAttribute ReservationVO reservationVO) {

        ModelAndView modelAndView = new ModelAndView("redirect: /user/list/reservation");
        ServiceResult serviceResult =
                orderService.reserve(reservationVO, httpServletRequest);
        return modelAndView;
    }


    @RequestMapping(value = "/list/reservation")
    public ModelAndView getReservation(HttpServletRequest httpServletRequest,
                                        @ModelAttribute ReservationRestrict reservationRestrict) {


        MyLogger.log(reservationRestrict);
        AttributeUpdate.clearObject(reservationRestrict, ReservationRestrict.class);
        ModelAndView modelAndView = new ModelAndView();
        ServiceResult serviceResult =
                orderService.getReservationByUser(httpServletRequest, reservationRestrict);


        MyLogger.log(serviceResult);

        modelAndView.setViewName("user/reservation");
        modelAndView.addObject("paginationResult", (PaginationResult)serviceResult.getValue());
        modelAndView.addObject("reservationRestrict", reservationRestrict);
        modelAndView.addObject("room", (ReservationShowMember)null);
        return modelAndView;
    }

    @RequestMapping(value = "/list/checkIn")
    public ModelAndView getCheckIn(HttpServletRequest httpServletRequest,
                                    @ModelAttribute ReservationRestrict reservationRestrict) {
        MyLogger.log(reservationRestrict);
        AttributeUpdate.clearObject(reservationRestrict, ReservationRestrict.class);

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
        AttributeUpdate.clearObject(reservationRestrict, ReservationRestrict.class);

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

    @RequestMapping(value = "/state/active")
    public ModelAndView active(HttpServletRequest httpServletRequest) {

        ModelAndView modelAndView = new ModelAndView("redirect: /user/user/info");
        ServiceResult serviceResult = userService.state(httpServletRequest, (short) 1);
        modelAndView.addObject("result",serviceResult);
        return modelAndView;
    }

    @RequestMapping(value = "/state/delete")
    public ModelAndView delete(HttpServletRequest httpServletRequest) {

        ModelAndView modelAndView = new ModelAndView("redirect: /");
        ServiceResult serviceResult = userService.state(httpServletRequest, (short) -1);
        return modelAndView;
    }

    @RequestMapping(value = "/state/destroy")
    public ModelAndView destroy(HttpServletRequest httpServletRequest) {

        ModelAndView modelAndView = new ModelAndView("/user/user");
        ServiceResult serviceResult = userService.state(httpServletRequest, (short) -1);
        modelAndView.addObject("result",serviceResult);
        return modelAndView;
    }

    @RequestMapping(value = "/level/{level}")
    public ModelAndView level(HttpServletRequest httpServletRequest,
                              @PathVariable(value = "level") short level) {

        ModelAndView modelAndView = new ModelAndView("/user/user");
        ServiceResult serviceResult = userService.level(httpServletRequest, level);
        modelAndView.addObject("result",serviceResult);
        return modelAndView;
    }


    @RequestMapping(value = "/exchange/{bonusPoint}")
    public ModelAndView exchange(HttpServletRequest httpServletRequest,
                                  @PathVariable("bonusPoint") long bonusPoint) {

        ModelAndView modelAndView = new ModelAndView("/user/user");
        ServiceResult serviceResult =
                userService.exchange(httpServletRequest, bonusPoint);
        modelAndView.addObject("result",serviceResult);
        return modelAndView;
    }


    @RequestMapping(value = "/update/info")
    public ModelAndView updateInformation(@ModelAttribute MemberVO member,
                                          HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/user");
        ServiceResult serviceResult = userService.updateInformation(httpServletRequest, member);
        modelAndView.addObject("user", serviceResult.getValue());
        modelAndView.addObject("message", serviceResult.getMessage());
        return modelAndView;
    }

    @RequestMapping(value = "/pay/{reservationId}")
    public ModelAndView pay(HttpServletRequest httpServletRequest,
                            @PathVariable("reservationId") Long reservationId) {

        ModelAndView modelAndView =
                new ModelAndView("redirect: /user/list/reservation");
        ServiceResult serviceResult =
                orderService.userPay(httpServletRequest, reservationId);
        modelAndView.addObject("result",serviceResult);
        return modelAndView;
    }

}
