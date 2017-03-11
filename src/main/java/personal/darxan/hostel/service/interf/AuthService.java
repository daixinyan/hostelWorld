package personal.darxan.hostel.service.interf;

import org.springframework.transaction.annotation.Transactional;
import personal.darxan.hostel.vo.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by darxan on 2017/2/15.
 */
@Transactional
public interface AuthService {

    /**
     * 通过用户名来查询数据库，在比对密码是否正确。
     * @param loginVO
     * @param httpServletRequest
     * @return
     */
    ServiceResult login(LoginVO loginVO, HttpServletRequest httpServletRequest);


    /**
     *
     * @param memberVO
     * @param httpServletRequest
     * @return
     */
    ServiceResult userRegister(MemberVO memberVO, HttpServletRequest httpServletRequest);

    /**
     *
     * @param hostelVO
     * @param httpServletRequest
     * @return
     */
    ServiceResult hostelRegister(HostelVO hostelVO, HttpServletRequest httpServletRequest);

    /**
     *
     * @param administerVO
     * @param httpServletRequest
     * @return
     */
    ServiceResult adminRegister(AdministerVO administerVO, HttpServletRequest httpServletRequest);


    /**
     *
     * @param httpServletRequest
     * @return
     */
    public ServiceResult getCurrentLogin(HttpServletRequest httpServletRequest);
}
