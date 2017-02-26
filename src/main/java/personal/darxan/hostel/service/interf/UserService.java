package personal.darxan.hostel.service.interf;

import personal.darxan.hostel.vo.MemberVO;
import personal.darxan.hostel.vo.ServiceResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by darxan on 2017/2/17.
 */
public interface UserService {

    public ServiceResult level(HttpServletRequest httpServletRequest) ;

    public ServiceResult exchange(HttpServletRequest httpServletRequest, long bonusPoint) ;

    public ServiceResult updateInformation(HttpServletRequest httpServletRequest, MemberVO member);
}
