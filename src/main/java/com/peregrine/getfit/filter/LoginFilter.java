package com.peregrine.getfit.filter;

import com.peregrine.getfit.entities.User;
import com.peregrine.getfit.util.Pages;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**Фильтр для отслеживания пользователя в сессии*/
public class LoginFilter implements Filter {
    private static Logger logger = Logger.getLogger(LoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        User user = (User) request.getSession().getAttribute("user");
        String command = request.getParameter("command");
        String uri = request.getRequestURI();
        if (command == null) {
            switch (uri){
                case "/account":
                    if(user == null) {
                        request.setAttribute("redirect", Pages.getInstance().getProperty(Pages.ERROR));
                    } else {
                        request.setAttribute("redirect", Pages.getInstance().getProperty(Pages.ACCOUNT));
                    }
                    break;
                case "/login":
                    if(user == null) {
                        request.setAttribute("redirect", Pages.getInstance().getProperty(Pages.LOGIN));
                    } else {
                        request.setAttribute("redirect", Pages.getInstance().getProperty(Pages.ACCOUNT));
                    }
                    break;
                case "/register":
                    if(user == null) {
                        request.setAttribute("redirect", Pages.getInstance().getProperty(Pages.REGISTER));
                    } else {
                        request.setAttribute("redirect", Pages.getInstance().getProperty(Pages.ACCOUNT));
                    }
                    default:
                        request.setAttribute("redirect", Pages.getInstance().getProperty(Pages.INDEX));
                        break;
            }
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
    @Override
    public void destroy() {

    }
}
