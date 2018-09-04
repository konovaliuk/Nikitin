package com.peregrine.getfit.commands;

import com.peregrine.getfit.entities.Consumption;
import com.peregrine.getfit.entities.Food;
import com.peregrine.getfit.entities.User;
import com.peregrine.getfit.services.ServiceConsumption;
import com.peregrine.getfit.services.ServiceFood;
import com.peregrine.getfit.util.IRequestHandler;
import com.peregrine.getfit.util.Pages;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

public class CreateConsumption implements IRequestHandler {
    private static Logger logger = LogManager.getLogger(CreateConsumption.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)  {
        Food chosenFood = ServiceFood.findFoodById(Integer.parseInt(request.getParameter("productId")));
        User currentUser = (User) request.getSession().getAttribute("user");
        logger.debug(currentUser);
        Consumption consumption = new Consumption();
        consumption.setDate(LocalDateTime.now());
        consumption.setAmount(Integer.parseInt(request.getParameter("amount")));
        consumption.setFood(chosenFood);
        consumption.setUser(currentUser);
        ServiceConsumption.createConsumption(consumption);
        return Pages.getInstance().getProperty(Pages.ACCOUNT);
    }
}
