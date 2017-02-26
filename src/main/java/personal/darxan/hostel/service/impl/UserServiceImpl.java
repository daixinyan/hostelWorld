package personal.darxan.hostel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.darxan.hostel.dao.MemberDao;
import personal.darxan.hostel.service.interf.UserService;
import personal.darxan.hostel.tool.AttributeUpdate;
import personal.darxan.hostel.tool.Convert;
import personal.darxan.hostel.tool.StringConstant;
import personal.darxan.hostel.vo.MemberVO;
import personal.darxan.hostel.vo.ServiceResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by darxan on 2017/2/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MemberDao memberDao;

    public ServiceResult level(HttpServletRequest httpServletRequest) {
        ServiceResult serviceResult = new ServiceResult(true);
        try {
            MemberVO memberVO = (MemberVO)httpServletRequest.getSession(false).getAttribute(StringConstant.SESSION_LOGIN);
            if (memberVO.getBalance()>10000) {
                memberVO.setLevel((short)(memberVO.getLevel()+1));
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

    public ServiceResult exchange(HttpServletRequest httpServletRequest, long bonusPoint) {
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
                                           MemberVO member) {

        ServiceResult serviceResult = new ServiceResult(true);
        try {
            MemberVO memberVO = (MemberVO)httpServletRequest
                    .getSession(false).getAttribute(StringConstant.SESSION_LOGIN);
            AttributeUpdate.udpate(memberVO, member, MemberVO.class);
            memberDao.update(Convert.convert(memberVO));
            serviceResult.setValue(memberVO);

        }catch (Exception e) {
            serviceResult.setSuccess(false);
            serviceResult.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return serviceResult;
    }

}
