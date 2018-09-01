package com.peregrine.getfit.commands;

import com.peregrine.getfit.util.IRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToPage implements IRequestHandler {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return request.getParameter("url");
    }
}
