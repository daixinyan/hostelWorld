package personal.darxan.hostel.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by darxan on 2017/2/14.
 */
@WebFilter("/*")
public class EncodingFilter implements Filter{
    private String targetEncoding = "UTF-8";


    public void init(FilterConfig config) throws ServletException {

    }


    public void doFilter(ServletRequest servletRequest , ServletResponse servletResponse , FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        request.setCharacterEncoding(targetEncoding);
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        response.setContentType("application/json; charset="+targetEncoding);
        chain.doFilter(servletRequest ,servletResponse);

    }

    public void destroy() {
    }
}
