package com.peregrine.getfit.commands;

import com.peregrine.getfit.entities.User;
import com.peregrine.getfit.services.ServiceLogin;
import com.peregrine.getfit.util.IRequestHandler;
import com.peregrine.getfit.util.Message;
import com.peregrine.getfit.util.Pages;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.logging.Logger;

public class Login implements IRequestHandler {
    private static final Logger logger = Logger.getLogger(CommandMissing.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)  {
        String page;
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = ServiceLogin.getRegisteredUser(email,password);

        logger.info("email = " + email + " | password = "+ password);
        logger.info("user = " + user);

        if (user != null) {
            request.getSession().setAttribute("user",user);
            page = Pages.getInstance().getProperty(Pages.ACCOUNT);
        } else {
            request.setAttribute("message", Message.getInstance().getProperty(Message.LOGIN_ERROR));
            page = Pages.getInstance().getProperty(Pages.LOGIN);
        }
        return page;
    }
}
