package com.peregrine.getfit.listeners;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class LoggerListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    private static final Logger logger = LogManager.getLogger(LoggerListener.class);

    public LoggerListener() {
    }
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        logger.info("Servlet context is initialized - " + sce.getServletContext().getContextPath());
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        logger.info("Session is created. Session id = "+ se.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        logger.info("Session is destroyed. Session id = "+ se.getSession().getId());

    }
    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
        logger.info("Attribute " + sbe.getName() + "is added to a session (id =" + sbe.getSession().getId() + ")");
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
