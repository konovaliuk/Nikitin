package com.peregrine.getfit.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Интерфейс описывающий метод для комманд.
 */
public interface IRequestHandler {

    /**
     * Метод выполняющий команду
     * @param request HttpServletRequest request
     * @param response HttpServletRequest response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
