package personal.darxan.hostel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.darxan.hostel.dao.MemberDao;
import personal.darxan.hostel.model.Member;
import personal.darxan.hostel.service.interf.UserService;
import personal.darxan.hostel.tool.AttributeUpdate;
import personal.darxan.hostel.tool.Convert;
import personal.darxan.hostel.tool.StringConstant;
import personal.darxan.hostel.vo.AdministerVO;
import personal.darxan.hostel.vo.MemberVO;
import personal.darxan.hostel.vo.ServiceResult;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by darxan on 2017/2/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MemberDao memberDao;

    public ServiceResult state(HttpServletRequest httpServletRequest, Short state)  {
        ServiceResult serviceResult = new ServiceResult(true);
        try {
            MemberVO memberVO = (MemberVO)httpServletRequest.getSession(false).getAttribute(StringConstant.SESSION_LOGIN);
            Member member = memberDao.load(memberVO.getMemberId());
            member.setState(state);
            memberVO.setState(state);

            if (state.shortValue()==1) {
                member.setBalance(1000.0);
                memberVO.setBalance(1000.0);
                member.setBonusPoint(1000000L);
                memberVO.setBonusPoint(1000000L);
                member.setLevel((short)1);
                memberVO.setLevel((short)1);
            }

            memberDao.update(member);
        }catch (Exception e) {
            serviceResult.setSuccess(false);
            serviceResult.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return serviceResult;
    }

    public ServiceResult getUser(Long userId) {
        ServiceResult serviceResult = new ServiceResult(true);
        try {
            Member member = memberDao.get(userId);
            if (member==null) {
                throw new Exception(StringConstant.NAME_NOT_EXIST);
            }
            serviceResult.setValue(Convert.convert(member));
        }catch (Exception e) {
            serviceResult.setSuccess(false);
            serviceResult.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return serviceResult;
    }

    public ServiceResult level(HttpServletRequest httpServletRequest, Short level) {
        ServiceResult serviceResult = new ServiceResult(true);
        try {
            MemberVO memberVO = (MemberVO)httpServletRequest.getSession(false).getAttribute(StringConstant.SESSION_LOGIN);
            Member member = memberDao.load(memberVO.getMemberId());
            member.setLevel(level);
            memberVO.setLevel(level);
            member.setBalance(member.getBalance()+1000.0);
            memberVO.setBalance(member.getBalance()+1000.0);
            member.setBonusPoint(member.getBonusPoint()+1000000L);
            memberVO.setBonusPoint(member.getBonusPoint()+1000000L);
            memberDao.update(member);
        }catch (Exception e) {
            serviceResult.setSuccess(false);
            serviceResult.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return serviceResult;
    }

    public ServiceResult recharge(HttpServletRequest httpServletRequest, double much) {
        ServiceResult serviceResult = new ServiceResult(true);
        try {
            MemberVO memberVO = (MemberVO)httpServletRequest
                    .getSession(false).getAttribute(StringConstant.SESSION_LOGIN);
            Member member = memberDao.get(memberVO.getMemberId());

            double current = member.getBalance()+much;
            member.setBalance(current);
            memberVO.setBalance(current);

            memberDao.update(member);
        }catch (Exception e) {
            serviceResult.setSuccess(false);
            serviceResult.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return serviceResult;
    }

    public ServiceResult exchange(HttpServletRequest httpServletRequest, Long bonusPoint) {
        ServiceResult serviceResult = new ServiceResult(true);
        try {
            MemberVO memberVO = (MemberVO)httpServletRequest
                    .getSession(false).getAttribute(StringConstant.SESSION_LOGIN);
            if (memberVO.getBonusPoint()>bonusPoint) {
                memberVO.setBonusPoint(memberVO.getBonusPoint()-bonusPoint);
                memberVO.setBalance(memberVO.getBalance()+bonusPoint/1000);
                memberDao.update(Convert.convert(memberVO));
            }else {
                serviceResult.setSuccess(false);
                serviceResult.setMessage(StringConstant.NOENOUGH_BALANCE);
            }
        }catch (Exception e) {
            serviceResult.setSuccess(false);
            serviceResult.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return serviceResult;
    }

    public ServiceResult updateInformation(HttpServletRequest httpServletRequest,
                                           MemberVO updatedMember) {

        ServiceResult serviceResult = new ServiceResult(true);
        try {
            Object login = httpServletRequest
                    .getSession(false).getAttribute(StringConstant.SESSION_LOGIN);

            boolean memberAuth = (login instanceof MemberVO) &&
                    ((MemberVO) login).getMemberId().equals(updatedMember.getMemberId());
            boolean adminAuth = (login instanceof AdministerVO);
            if ( !memberAuth && !adminAuth) {
                throw new Exception(StringConstant.AUTH_WRONG);
            }

            Member memberPersistent = memberDao.get(updatedMember.getMemberId());
            Member memberEntity = Convert.convert(updatedMember);


            AttributeUpdate.update(memberPersistent, memberEntity, Member.class);

            memberPersistent.setUpdateTime(new Date());
            memberDao.update(memberPersistent);

            if (memberAuth) {
                serviceResult.setValue(((MemberVO) login));
                AttributeUpdate.update(((MemberVO) login), updatedMember, MemberVO.class);
            }


        }catch (Exception e) {
            serviceResult.setSuccess(false);
            serviceResult.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return serviceResult;
    }

}
