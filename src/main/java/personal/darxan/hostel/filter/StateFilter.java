package personal.darxan.hostel.filter;

import personal.darxan.hostel.tool.StringConstant;
import personal.darxan.hostel.vo.MemberVO;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by darxan on 2017/3/9.
 */
public abstract class StateFilter implements Filter {


    public void init(FilterConfig filterConfig) throws ServletException{

    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        try {
            if (stateOk(httpServletRequest.getSession())) {
                doFilter(request, response, chain);
            }
            ((HttpServletResponse)response).sendRedirect(statePage());
        }catch (NullPointerException e) {
            ((HttpServletResponse)response).sendRedirect(getLoginPage());
        }catch (ClassCastException e) {
            ((HttpServletResponse)response).sendRedirect(getLoginPage());
        }
    }

    protected abstract boolean stateOk(HttpSession session);

    protected abstract String getLoginPage();

    protected abstract String statePage() ;

    public void destroy() {

    }
}
