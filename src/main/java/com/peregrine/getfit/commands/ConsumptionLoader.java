package com.peregrine.getfit.commands;

import com.peregrine.getfit.entities.Consumption;
import com.peregrine.getfit.entities.User;
import com.peregrine.getfit.services.ServiceConsumption;
import com.peregrine.getfit.util.IRequestHandler;
import com.peregrine.getfit.util.Pages;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ConsumptionLoader implements IRequestHandler {
    private static final Logger logger = LogManager.getLogger(FoodLoader.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("FoodLoader().execute");
        User user = (User)request.getSession().getAttribute("user");
        logger.debug("CONSUMPTIONLOADER + user = " + user);
        ArrayList<Consumption> consumptionList = ServiceConsumption.getConsumptionsForCurrentUser(user);
        request.getSession().setAttribute("consumptions", consumptionList);
        return Pages.getInstance().getProperty(Pages.ACCOUNT);
    }
}
