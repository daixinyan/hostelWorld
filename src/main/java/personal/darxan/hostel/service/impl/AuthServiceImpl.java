package personal.darxan.hostel.service.impl;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import personal.darxan.hostel.dao.AdministerDao;
import personal.darxan.hostel.dao.HostelDao;
import personal.darxan.hostel.dao.MemberDao;
import personal.darxan.hostel.model.Administer;
import personal.darxan.hostel.model.Hostel;
import personal.darxan.hostel.model.Member;
import personal.darxan.hostel.model.base.Loginable;
import personal.darxan.hostel.service.interf.AuthService;
import personal.darxan.hostel.tool.Convert;
import personal.darxan.hostel.tool.MyLogger;
import personal.darxan.hostel.tool.StringConstant;
import personal.darxan.hostel.vo.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by darxan on 2017/2/15.
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private AdministerDao adminDao;

    @Autowired
    private HostelDao hostelDao;

    public ServiceResult getCurrentLogin(HttpServletRequest httpServletRequest) {
        ServiceResult serviceResult = new ServiceResult(false);
        serviceResult.setMessage(StringConstant.AUTH_WRONG);
        HttpSession session = httpServletRequest.getSession(false);
        if (session==null) {
            return serviceResult;
        }
        Object login = session.getAttribute(StringConstant.SESSION_LOGIN);
        if (login==null) {
            return serviceResult;
        }

        serviceResult.setSuccess(true);
        serviceResult.setValue(login);

        return serviceResult;
    }

    public ServiceResult login(LoginVO loginVO,
                               HttpServletRequest httpServletRequest) {

        Loginable entity = null;
        ServiceResult result = new ServiceResult(false);

        if (loginVO.getLoginType().equals(StringConstant.HOSTEL)) {
            entity = hostelDao.getByName(loginVO.getName());
            result.setValue(Convert.convert((Hostel)entity));
        } else if (loginVO.getLoginType().equals(StringConstant.ADMIN)) {
            entity = adminDao.getByName(loginVO.getName());
            result.setValue(Convert.convert((Administer)entity));
        } else {
            entity = memberDao.getByName(loginVO.getName());
            result.setValue(Convert.convert((Member)entity));
        }

        if (entity==null) {
            result.setMessage(StringConstant.NAME_NOT_EXIST);
        } else if (!entity.getPassword().equals(loginVO.getPassword())) {
            result.setMessage(StringConstant.WRONG_PASSWORD);
        } else {
            result.setSuccess(true);
            HttpSession httpSession = httpServletRequest.getSession();
            httpSession.setAttribute(
                    StringConstant.SESSION_LOGIN,
                    result.getValue());
            httpSession.setAttribute(
                    StringConstant.SESSION_LOGIN_TYPE,
                    result.getValue().getClass().getName());
        }

        return result;
    }

    public ServiceResult userRegister(MemberVO memberVO,
                                      HttpServletRequest httpServletRequest) {

        ServiceResult serviceResult = new ServiceResult(true);

        try {
            Member member = Convert.convert(memberVO);
            memberDao.save(member);
        }catch (HibernateException e) {
            serviceResult.setSuccess(false);
            serviceResult.setMessage(e.getMessage());
        }
        return serviceResult;
    }

    public ServiceResult hostelRegister(HostelVO hostelVO,
                                        HttpServletRequest httpServletRequest) {

        ServiceResult serviceResult = new ServiceResult(true);

        try {
            Hostel hostel = Convert.convert(hostelVO);
            hostelDao.save(hostel);
        }catch (HibernateException e) {
            serviceResult.setSuccess(false);
            serviceResult.setMessage(e.getMessage());
        }
        return serviceResult;
    }

    public ServiceResult adminRegister(AdministerVO administerVO,
                                       HttpServletRequest httpServletRequest) {

        ServiceResult serviceResult = new ServiceResult(true);

        try {
            Administer administer = Convert.convert(administerVO);
            adminDao.save(administer);
        }catch (HibernateException e) {
            serviceResult.setSuccess(false);
            serviceResult.setMessage(e.getMessage());
        }
        return serviceResult;

    }
}
