package personal.darxan.hostel.filter;

import personal.darxan.hostel.tool.StringConstant;
import personal.darxan.hostel.vo.MemberVO;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;

/**
 * Created by darxan on 2017/3/9.
 */
@WebFilter(
        value = {
                "/user/cancel/*",
                "/user/reserve/*",
                "/user/exchange/*"
        }
)
public class UserStateFilter extends StateFilter {

    protected boolean stateOk(HttpSession session) {
        Object userVO = session.getAttribute(StringConstant.SESSION_LOGIN);
        if( userVO!=null && userVO instanceof MemberVO) {
            MemberVO memberVO = (MemberVO)userVO;
            return memberVO.getState()>=1;
        }
        return false;
    }

    protected String getLoginPage() {
        return "/public/login/user";
    }


    protected String statePage() {
        return "/user/user/info";
    }
}
