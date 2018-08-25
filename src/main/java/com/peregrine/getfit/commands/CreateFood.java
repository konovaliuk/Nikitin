package com.peregrine.getfit.commands;

import com.peregrine.getfit.entities.Food;
import com.peregrine.getfit.services.ServiceFood;
import com.peregrine.getfit.util.IRequestHandler;
import com.peregrine.getfit.util.Pages;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateFood implements IRequestHandler {
    private static final Logger logger = LogManager.getLogger(FoodLoader.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)  {
        Food food = new Food();
        food.setName(request.getParameter("name"));
        food.setFat(Double.parseDouble(request.getParameter("fat")));
        food.setProtein(Double.parseDouble(request.getParameter("protein")));
        food.setCarb(Double.parseDouble(request.getParameter("carb")));
        food.setCalories(Double.parseDouble(request.getParameter("calories")));

        logger.debug(request.getParameter("name") +
                " fat =  "+ request.getParameter("fat") +
                " protein = " + request.getParameter("protein") +
                " carb = " + request.getParameter("carb") +
                " calories = " + request.getParameter("calories"));

        ServiceFood.addFood(food);
        logger.debug("CreateFood execute");
        return Pages.getInstance().getProperty(Pages.CUSTOM);
    }
}
