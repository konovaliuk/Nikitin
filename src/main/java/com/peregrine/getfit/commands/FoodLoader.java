package com.peregrine.getfit.commands;

import com.peregrine.getfit.entities.Food;
import com.peregrine.getfit.services.ServiceFood;
import com.peregrine.getfit.util.IRequestHandler;
import com.peregrine.getfit.util.Pages;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


public class FoodLoader implements IRequestHandler {
    private static final Logger logger = LogManager.getLogger(FoodLoader.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("FoodLoader().execute");
        ArrayList<Food> foodList = ServiceFood.getFoodList();
        request.setAttribute("food", foodList);
        return Pages.getInstance().getProperty(Pages.ACCOUNT);
    }
}
