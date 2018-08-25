package com.peregrine.getfit.commands;

import com.peregrine.getfit.util.IRequestHandler;
import com.peregrine.getfit.util.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout implements IRequestHandler {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        request.getSession().invalidate();
        return Pages.getInstance().getProperty(Pages.INDEX);
    }
}
