package com.peregrine.getfit.commands;

import com.google.gson.Gson;
import com.peregrine.getfit.entities.Food;
import com.peregrine.getfit.services.ServiceFood;
import com.peregrine.getfit.util.IRequestHandler;
import com.peregrine.getfit.util.Pages;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class FoodLoader implements IRequestHandler {
    private static final Logger logger = LogManager.getLogger(FoodLoader.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.debug("FoodLoader().execute");
        ArrayList<Food> foodList = ServiceFood.getFoodList();

//        String json = new Gson().toJson(foodList);
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write(json);

        request.setAttribute("foods", foodList);
        return Pages.getInstance().getProperty(Pages.ACCOUNT);
    }
}
