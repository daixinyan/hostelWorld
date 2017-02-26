package personal.darxan.hostel.filter;

import personal.darxan.hostel.tool.StringConstant;
import personal.darxan.hostel.vo.HostelVO;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;

/**
 * Created by darxan on 2017/2/15.
 */
@WebFilter(value = "/hostel")
public class HostelFilter extends AuthFilter {

    @Override
    protected boolean login(HttpSession session) {
        Object hostelVO = session.getAttribute(StringConstant.SESSION_LOGIN);
        return hostelVO!=null && hostelVO instanceof HostelVO;
    }

    @Override
    protected String getLoginPage() {
        return "/public/login/hostel";
    }
}
