package personal.darxan.hostel.filter;

import personal.darxan.hostel.tool.StringConstant;
import personal.darxan.hostel.vo.HostelVO;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;

/**
 * Created by darxan on 2017/3/9.
 */
@WebFilter(
        value = {
                "/hostel/increment",
                "/hostel/update/schedule",
                "/hostel/action/schedule",
                "/hostel/action/checkIn",
                "/hostel/action/checkOut"
        }
        )
public class HostelStateFilter extends StateFilter {

    protected boolean stateOk(HttpSession session) {
        Object login = session.getAttribute(StringConstant.SESSION_LOGIN);
        if( login!=null && login instanceof HostelVO) {
            HostelVO hostel = (HostelVO)login;
            return hostel.getState()>=1;
        }
        return false;
    }

    protected String getLoginPage() {
        return "/public/login/hostel";
    }


    protected String statePage() {
        return "/hostel/hostel/info";
    }
}
