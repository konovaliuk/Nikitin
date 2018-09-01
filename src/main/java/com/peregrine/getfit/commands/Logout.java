package com.peregrine.getfit.commands;

import com.peregrine.getfit.util.IRequestHandler;
import com.peregrine.getfit.util.Pages;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout implements IRequestHandler {
    private static final Logger logger = LogManager.getLogger(Registration.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("consumption");
        request.getSession().invalidate();
        logger.info("user has logged out");
        logger.info("user = " + request.getSession().getAttribute("user"));
        return Pages.getInstance().getProperty(Pages.INDEX);
    }
}
