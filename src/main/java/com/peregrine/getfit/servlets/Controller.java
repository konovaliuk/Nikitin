package com.peregrine.getfit.servlets;
import com.peregrine.getfit.util.IRequestHandler;
import com.peregrine.getfit.util.Message;
import com.peregrine.getfit.util.Pages;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Controller extends HttpServlet {
    private static Logger logger = LogManager.getLogger(Controller.class);

    ControllerHelper controllerHelper = ControllerHelper.getInstance();

    @Override
    public void init() throws ServletException {
        super.init();
        logger.trace("Init servlet");
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        String redirect = (String) request.getAttribute("redirect");

        if (redirect == null) {
            IRequestHandler command = controllerHelper.getCommand(request);
            logger.debug("class = " + command.getClass().getName());
            page = command.execute(request,response);
        } else {
            page = redirect;
        }
        logger.debug("PAGE = " + page);
        request.getRequestDispatcher(page).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post method");
        processRequest(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get method");
        processRequest(request,response);
    }
}
