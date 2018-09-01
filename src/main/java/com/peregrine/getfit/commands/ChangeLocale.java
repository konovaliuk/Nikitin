package com.peregrine.getfit.commands;

import com.peregrine.getfit.util.IRequestHandler;
import com.peregrine.getfit.util.Pages;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeLocale implements IRequestHandler {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String locale = request.getParameter("language");
        request.getSession().setAttribute("language", locale);
        return Pages.getInstance().getProperty(request.getParameter("PAGE"));
    }
}
