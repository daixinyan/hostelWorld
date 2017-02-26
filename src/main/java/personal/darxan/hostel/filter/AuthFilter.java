package personal.darxan.hostel.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by darxan on 2017/2/14.
 */
public abstract class AuthFilter implements Filter {
    private String targetEncoding = "UTF-8";


    public void init(FilterConfig config) throws ServletException {
    }


    public void doFilter(ServletRequest servletRequest , ServletResponse servletResponse , FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        if (login(request.getSession(false))) {
            chain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect(getLoginPage());
        }
    }

    protected abstract boolean login(HttpSession session);

    protected abstract String getLoginPage();

    public void destroy() {
    }

}
