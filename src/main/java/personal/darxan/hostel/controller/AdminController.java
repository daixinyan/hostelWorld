package personal.darxan.hostel.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import personal.darxan.hostel.service.interf.AdminService;
import personal.darxan.hostel.service.interf.HostelService;
import personal.darxan.hostel.service.interf.OrderService;
import personal.darxan.hostel.vo.ReservationRestrict;
import personal.darxan.hostel.vo.ServiceResult;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by darxan on 2017/2/14.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private OrderService orderService;

    private HostelService hostelService;

    private AdminService adminService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = "/admin")
    public ModelAndView  admin(HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/admin");
        return modelAndView;
    }

    @RequestMapping(value = "/user")
    public ModelAndView  user(HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/user");
        return modelAndView;
    }

    @RequestMapping(value = "/hostel")
    public ModelAndView  hostel(HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/hostel");
        return modelAndView;
    }

    @RequestMapping(value = "/verify//{pass}")
    @ResponseBody
    public ServiceResult  verifyHostels(HttpServletRequest httpServletRequest,
                                        @PathVariable("hostelId") Long hostelId,
                                        @PathVariable("pass") Boolean pass) {
        return hostelService.verifyHostel(httpServletRequest, hostelId, pass);
    }

    @RequestMapping(value = "/pay/")
    public ModelAndView payHostel(HttpServletRequest httpServletRequest,
                                  @PathVariable("hostelId") String hostelId) {
        ModelAndView modelAndView = new ModelAndView();
        ServiceResult serviceResult = adminService.payHostel(httpServletRequest, hostelId);
        return modelAndView;
    }

    @RequestMapping(value = "/finance")
    public ModelAndView finance(HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        ServiceResult serviceResult = adminService.finance(httpServletRequest);
        return modelAndView;
    }

    @RequestMapping(value = "/user/reservation")
    @ResponseBody
    public ServiceResult getUserReservation(HttpServletRequest httpServletRequest,
                                            @ModelAttribute ReservationRestrict reservationRestrict) {
        ServiceResult serviceResult =
                orderService.getReservationByUser(httpServletRequest, reservationRestrict);
        return serviceResult;
    }

    @RequestMapping(value = "/user/checkIn")
    @ResponseBody
    public ServiceResult getUserCheckIn(HttpServletRequest httpServletRequest,
                                        @ModelAttribute ReservationRestrict reservationRestrict) {
        ServiceResult serviceResult =
                orderService.getCheckInByUser(httpServletRequest, reservationRestrict);
        return serviceResult;
    }

    @RequestMapping(value = "/user/payment")
    @ResponseBody
    public ServiceResult getUserPayment(HttpServletRequest httpServletRequest,
                                        @ModelAttribute ReservationRestrict reservationRestrict) {
        ServiceResult serviceResult =
                orderService.getPaymentByUser(httpServletRequest, reservationRestrict);
        return serviceResult;
    }

    @RequestMapping(value = "/hostel/reservation")
    @ResponseBody
    public ServiceResult getHostelReservation(HttpServletRequest httpServletRequest,
                                              @ModelAttribute ReservationRestrict reservationRestrict) {
        ServiceResult serviceResult =
                orderService.getReservationByHostel(httpServletRequest, reservationRestrict);
        return serviceResult;
    }

    @RequestMapping(value = "/hostel/checkIn")
    @ResponseBody
    public ServiceResult getHostelCheckIn(HttpServletRequest httpServletRequest,
                                          @ModelAttribute ReservationRestrict reservationRestrict) {
        ServiceResult serviceResult =
                orderService.getCheckInByHostel(httpServletRequest, reservationRestrict);
        return serviceResult;
    }

    @RequestMapping(value = "/hostel/payment")
    @ResponseBody
    public ServiceResult getHostelPayment(HttpServletRequest httpServletRequest,
                                          @ModelAttribute ReservationRestrict reservationRestrict) {
        ServiceResult serviceResult =
                orderService.getPaymentByHostel(httpServletRequest, reservationRestrict);
        return serviceResult;
    }
}
