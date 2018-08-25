package com.peregrine.getfit.commands;

import com.peregrine.getfit.entities.User;
import com.peregrine.getfit.services.ServiceRegistration;
import com.peregrine.getfit.util.IRequestHandler;
import com.peregrine.getfit.util.Pages;
import com.peregrine.getfit.util.PasswordCypher;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Registration implements IRequestHandler {
    private static final Logger logger = LogManager.getLogger(Registration.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        logger.info("execute registration");
        User user = new User();
        try {
            user.setFirstName(request.getParameter("firstname"));
            user.setLastName(request.getParameter("lastname"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(PasswordCypher.hashGenerator(request.getParameter("password")));
            user.setGender(request.getParameter("gender"));
            user.setAge(Integer.parseInt(request.getParameter("age")));
            user.setWeight(Double.parseDouble(request.getParameter("weight")));
            user.setHeight(Double.parseDouble(request.getParameter("height")));
            user.setLifestyle(request.getParameter("lifestyle"));

            ServiceRegistration.registerUser(user);
            request.getSession().setAttribute("user",user);
            page = Pages.getInstance().getProperty(Pages.ACCOUNT);
        }
        catch (PasswordCypher.CannotPerformOperationException e) {
            logger.error("error = " + e.getMessage());
            page = Pages.getInstance().getProperty(Pages.ERROR);
        }
        return page;
    }
}
