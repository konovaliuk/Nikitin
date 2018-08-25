package com.peregrine.getfit.services;

import com.peregrine.getfit.dao.AbstractDAOFactory;
import com.peregrine.getfit.entities.Food;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class ServiceFood {
    private static final Logger logger = LogManager.getLogger(ServiceFood.class);

    public static ArrayList<Food> getFoodList() {
        AbstractDAOFactory factory = AbstractDAOFactory.getDAOFactory("MySql");
        ArrayList<Food> foodList = factory.getFoodDAO().findAll();
        logger.info("getFoodList()");
        return foodList;
    }
    public static boolean addFood(Food food) {
        AbstractDAOFactory factory = AbstractDAOFactory.getDAOFactory("MySql");
        int success = factory.getFoodDAO().create(food);
        logger.info("addFood() = " + success);
        return success > 0;
    }
    public static Food findFoodById(Integer id) {
        AbstractDAOFactory factory = AbstractDAOFactory.getDAOFactory("MySql");
        Food food = factory.getFoodDAO().findFoodById(id);
        return food;
    }
}
