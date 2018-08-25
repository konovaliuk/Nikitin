package com.peregrine.getfit.commands;

import com.peregrine.getfit.util.IRequestHandler;
import com.peregrine.getfit.util.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class CommandMissing implements IRequestHandler {
    private static final Logger logger = Logger.getLogger(CommandMissing.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        logger.info("command missing");
        return Pages.getInstance().getProperty(Pages.ERROR);
    }
}
