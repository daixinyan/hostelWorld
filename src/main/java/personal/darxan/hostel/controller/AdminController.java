package personal.darxan.hostel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import personal.darxan.hostel.service.interf.AdminService;
import personal.darxan.hostel.service.interf.HostelService;
import personal.darxan.hostel.service.interf.OrderService;
import personal.darxan.hostel.service.interf.UserService;
import personal.darxan.hostel.tool.DateFormatter;
import personal.darxan.hostel.vo.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by darxan on 2017/2/14.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private HostelService hostelService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(DateFormatter.dateFormat, false));
    }

    @RequestMapping(value = "/admin/info")
    public ModelAndView  admin(HttpServletRequest httpServletRequest,
                               @ModelAttribute ReservationRestrict reservationRestrict) {
       return getReservation(httpServletRequest, reservationRestrict);
    }

    @RequestMapping(value = "/list/hostels")
    public ModelAndView  hostels(HttpServletRequest httpServletRequest,
                                 @ModelAttribute UsersRestrict usersRestrict) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/hostels");
        ServiceResult serviceResult
                = adminService.listHostels(httpServletRequest, usersRestrict);
        modelAndView.addObject("paginationResult", (PaginationResult)serviceResult.getValue());
        modelAndView.addObject("restrict", usersRestrict);
        modelAndView.addObject("hostel", (HostelVO)null);
        modelAndView.addObject("result", serviceResult);
        return modelAndView;
    }

    @RequestMapping(value = "/list/users")
    public ModelAndView  users(HttpServletRequest httpServletRequest,
                               @ModelAttribute UsersRestrict usersRestrict) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/users");
        ServiceResult serviceResult
                = adminService.listUsers(httpServletRequest, usersRestrict);
        modelAndView.addObject("paginationResult", (PaginationResult)serviceResult.getValue());
        modelAndView.addObject("restrict", usersRestrict);
        modelAndView.addObject("user", (MemberVO)null);
        modelAndView.addObject("result", serviceResult);
        return modelAndView;
    }

    @RequestMapping(value = "/update/hostel")
    public ModelAndView  updateHostels(HttpServletRequest httpServletRequest,
                                 @ModelAttribute HostelVO hostelVO) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect: /admin/list/hostels");
        ServiceResult serviceResult
                = hostelService.updateHostel(httpServletRequest, hostelVO);
        modelAndView.addObject("result", serviceResult);
        return modelAndView;
    }

    @RequestMapping(value = "/update/user")
    public ModelAndView  updateUser(HttpServletRequest httpServletRequest,
                                    @ModelAttribute MemberVO memberVO) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect: /admin/list/users");
        ServiceResult serviceResult
                = userService.updateInformation(httpServletRequest, memberVO);
        modelAndView.addObject("result", serviceResult);

        return modelAndView;
    }




    @RequestMapping(value = "/verify/{hostelId}/{pass}")
    public ModelAndView  verifyHostels(HttpServletRequest httpServletRequest,
                                        @PathVariable("hostelId") Long hostelId,
                                        @PathVariable("pass") Boolean pass) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect: admin/hostels");
        ServiceResult serviceResult
                = hostelService.verifyHostel(httpServletRequest, hostelId, pass);
        modelAndView.addObject("result", serviceResult);
        return modelAndView;
    }

    @RequestMapping(value = "/pay/{hostelId}")
    public ModelAndView payHostel(HttpServletRequest httpServletRequest,
                                  @PathVariable("hostelId") Long hostelId) {
        ModelAndView modelAndView = new ModelAndView("redirect: admin/hostels");
        ServiceResult serviceResult = adminService.payHostel(httpServletRequest, hostelId);
        modelAndView.addObject("result",serviceResult);
        return modelAndView;
    }

    @RequestMapping(value = "/list/reservation")
    public ModelAndView getReservation(HttpServletRequest httpServletRequest,
                                        @ModelAttribute ReservationRestrict reservationRestrict) {

        ModelAndView modelAndView = new ModelAndView("admin/admin");
        ServiceResult serviceResult = orderService.getReservation(
                httpServletRequest, reservationRestrict);
        modelAndView.addObject("result",serviceResult);
        modelAndView.addObject("paginationResult", (PaginationResult)serviceResult.getValue());
        modelAndView.addObject("reservationRestrict", reservationRestrict);
        return modelAndView;
    }

    @RequestMapping(value = "/user/reservation")
    public ModelAndView userReservation(HttpServletRequest httpServletRequest,
                                          @ModelAttribute ReservationRestrict reservationRestrict) {

        ModelAndView modelAndView = new ModelAndView("admin/reservation");
        ServiceResult serviceResult = orderService.getReservationByUser(
                httpServletRequest, reservationRestrict);
        modelAndView.addObject("result",serviceResult);
        modelAndView.addObject("paginationResult", (PaginationResult)serviceResult.getValue());
        modelAndView.addObject("reservationRestrict", reservationRestrict);
        return modelAndView;
    }


    @RequestMapping(value = "/hostel/reserved")
    public ModelAndView hostelReservation(HttpServletRequest httpServletRequest,
                                        @ModelAttribute ReservationRestrict reservationRestrict) {

        ModelAndView modelAndView = new ModelAndView("admin/reserved");
        ServiceResult serviceResult = orderService.getPaymentByHostel(
                httpServletRequest, reservationRestrict);
        modelAndView.addObject("result",serviceResult);
        modelAndView.addObject("paginationResult", (PaginationResult)serviceResult.getValue());
        modelAndView.addObject("reservationRestrict", reservationRestrict);
        return modelAndView;
    }


    @RequestMapping(value = "/stat/reservation")
    public ModelAndView statReservation(HttpServletRequest httpServletRequest) {

        ModelAndView modelAndView = new ModelAndView("admin/stat");
        return modelAndView;
    }









}
