package com.peregrine.getfit.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public interface IRequestHandler {
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
