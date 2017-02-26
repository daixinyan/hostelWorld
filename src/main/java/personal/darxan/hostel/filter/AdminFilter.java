package personal.darxan.hostel.filter;

import personal.darxan.hostel.tool.StringConstant;
import personal.darxan.hostel.vo.AdministerVO;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;

/**
 * Created by darxan on 2017/2/15.
 */
@WebFilter(value = "/admin")
public class AdminFilter extends AuthFilter {

    @Override
    protected boolean login(HttpSession session) {
        Object hostelVO = session.getAttribute(StringConstant.SESSION_LOGIN);
        return hostelVO!=null && hostelVO instanceof AdministerVO;
    }

    @Override
    protected String getLoginPage() {
        return "/public/login/admin";
    }
}
