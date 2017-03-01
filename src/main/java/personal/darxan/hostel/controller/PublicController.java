package personal.darxan.hostel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import personal.darxan.hostel.service.interf.AuthService;
import personal.darxan.hostel.service.interf.HostelService;
import personal.darxan.hostel.service.interf.SearchService;
import personal.darxan.hostel.tool.*;
import personal.darxan.hostel.vo.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by darxan on 2017/2/14.
 */
@Controller
@RequestMapping(value = "/public")
public class PublicController {

    @Autowired
    private AuthService authService;

    @Autowired
    private SearchService searchService;

    @Autowired
    private HostelService hostelService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(DateFormatter.dateFormat, false));
    }



    @RequestMapping(value = "/list/hostel")
    public ModelAndView hostels(HttpServletRequest httpServletRequest,
                                @ModelAttribute SearchRestrict searchRestrict) {

        MyLogger.log(searchRestrict);
        AttributeUpdate.clearObject(searchRestrict, SearchRestrict.class);
        MyLogger.log(searchRestrict);
        ModelAndView modelAndView = new ModelAndView();
        ServiceResult serviceResult = searchService.search(searchRestrict, httpServletRequest);
        MyLogger.log(serviceResult);

        modelAndView.setViewName("public/hostels");
        if (serviceResult.isSuccess()) {
            modelAndView.addObject("hostels", (PaginationResult)serviceResult.getValue());
        }
        modelAndView.addObject("searchRestrict", searchRestrict);
        modelAndView.addObject("room", (HostelRoomVO)null);
        return modelAndView;
    }

    @RequestMapping("/hostel/{hostelId}")
    public ModelAndView roomsByHostel(HttpServletRequest httpServletRequest,
                                      @PathVariable("hostelId") Long hostelId) {
        ModelAndView modelAndView = new ModelAndView("public/hostel");
        ServiceResult serviceResult = hostelService.getHostels(httpServletRequest, hostelId);
        MyPair<HostelVO, List<HostelRoomVO>> pair =
                (MyPair<HostelVO, List<HostelRoomVO>>) serviceResult.getValue();
        modelAndView.addObject("hostel", pair.getFirst());
        modelAndView.addObject("rooms",  pair.getSecond());
        return modelAndView;
    }

    @RequestMapping(value = "/room/{roomId}")
    public ModelAndView hostels(HttpServletRequest httpServletRequest, @PathVariable("roomId") Long roomId) {

        ModelAndView modelAndView = new ModelAndView();
        ServiceResult serviceResult = hostelService.getRoomById(httpServletRequest, roomId);
        MyLogger.log(serviceResult);

        modelAndView.setViewName("public/room");
        modelAndView.addObject("room", (HostelRoomVO)serviceResult.getValue());
        return modelAndView;
    }

    @RequestMapping(value = "/user/{userId}")
    public ModelAndView user(HttpServletRequest httpServletRequest, @PathVariable("userId") Long userId) {

        ModelAndView modelAndView = new ModelAndView();
        ServiceResult serviceResult = null;
        MyLogger.log(serviceResult);

        modelAndView.setViewName("public/user");
        modelAndView.addObject("user", (HostelRoomVO)serviceResult.getValue());
        return modelAndView;
    }

    @RequestMapping(value = "/login/default")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("public/login");
        modelAndView.addObject("type", "user");
        return modelAndView;
    }

    @RequestMapping(value = "/login/{type}")
    public ModelAndView login(@PathVariable("type") String type) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("public/login");
        modelAndView.addObject("type", type);
        return modelAndView;
    }



    @RequestMapping(value = "/action/login")
    public ModelAndView loginAction(HttpServletRequest httpServletRequest,
                                    @ModelAttribute LoginVO loginVO) {

        MyLogger.log(loginVO);

        ModelAndView modelAndView = new ModelAndView();

        ServiceResult serviceResult = authService.login(loginVO, httpServletRequest);
        MyLogger.log(serviceResult);

        if (serviceResult.isSuccess()) {
            if (loginVO.getLoginType().equals(StringConstant.ADMIN)) {
                modelAndView.setViewName("redirect: /admin/admin");
            }else if (loginVO.getLoginType().equals(StringConstant.HOSTEL)){
                modelAndView.setViewName("redirect: /hostel/hostel/info");
            }else {
                modelAndView.setViewName("redirect: /user/user/info");
            }
        } else {
            modelAndView.setViewName("public/login");
            modelAndView.addObject("cache", loginVO);
            modelAndView.addObject("message", serviceResult.getMessage());
        }
        return modelAndView;
    }


    @RequestMapping(value = "/register/userAction")
    public ModelAndView registerUserAction(@ModelAttribute MemberVO memberVO) {

        MyLogger.log(memberVO);

        ModelAndView modelAndView = new ModelAndView();

        ServiceResult serviceResult = authService.userRegister(memberVO, null);

        if (serviceResult.isSuccess()) {
            modelAndView.setViewName("public/login");
            modelAndView.addObject("type", "user");
        } else {
            modelAndView.setViewName("/user/register");
            modelAndView.addObject("cache", memberVO);
            modelAndView.addObject("message", serviceResult.getMessage());
        }

        return modelAndView;
    }


    @RequestMapping(value = "/register/hostelAction")
    public ModelAndView registerHostelAction(HttpServletRequest httpServletRequest,
                                             @ModelAttribute HostelVO hostelVO) {
        MyLogger.log(hostelVO);

        ModelAndView modelAndView = new ModelAndView();

        ServiceResult serviceResult = authService.hostelRegister(hostelVO, httpServletRequest);

        if (serviceResult.isSuccess()) {
            modelAndView.setViewName("public/login");
            modelAndView.addObject("type", "hostel");
        } else {
            modelAndView.setViewName("/hostel/register");
            modelAndView.addObject("cache", hostelVO);
            modelAndView.addObject("message", serviceResult.getMessage());
        }

        return modelAndView;
    }


    @RequestMapping(value = "/register/user")
    public ModelAndView registerUser() {
        ModelAndView modelAndView = new ModelAndView("/user/register");
        return modelAndView;
    }

    @RequestMapping(value = "/register/hostel")
    public ModelAndView registerHostel() {
        ModelAndView modelAndView = new ModelAndView("/hostel/register");
        return modelAndView;
    }

}
