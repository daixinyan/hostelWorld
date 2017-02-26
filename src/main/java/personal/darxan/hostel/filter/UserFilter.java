package personal.darxan.hostel.filter;

import personal.darxan.hostel.tool.StringConstant;
import personal.darxan.hostel.vo.MemberVO;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;

/**
 * Created by darxan on 2017/2/15.
 */
@WebFilter(value = "/user")
public class UserFilter extends AuthFilter {

    @Override
    protected boolean login(HttpSession session) {
        Object hostelVO = session.getAttribute(StringConstant.SESSION_LOGIN);
        return hostelVO!=null && hostelVO instanceof MemberVO;
    }

    @Override
    protected String getLoginPage() {
        return "/public/login/user";
    }
}
