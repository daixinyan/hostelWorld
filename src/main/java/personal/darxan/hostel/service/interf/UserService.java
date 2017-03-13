package personal.darxan.hostel.service.interf;

import personal.darxan.hostel.vo.MemberVO;
import personal.darxan.hostel.vo.ServiceResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by darxan on 2017/2/17.
 */
public interface UserService {

    public ServiceResult state(HttpServletRequest httpServletRequest, Short state) ;

    public ServiceResult level(HttpServletRequest httpServletRequest, Short level) ;

    public ServiceResult exchange(HttpServletRequest httpServletRequest, Long bonusPoint) ;

    public ServiceResult updateInformation(HttpServletRequest httpServletRequest, MemberVO member);
}
