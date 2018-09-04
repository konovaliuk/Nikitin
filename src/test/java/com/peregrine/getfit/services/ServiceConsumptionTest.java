package com.peregrine.getfit.services;

import com.peregrine.getfit.entities.Consumption;
import com.peregrine.getfit.entities.Food;
import com.peregrine.getfit.entities.User;
import junit.framework.TestCase;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class ServiceConsumptionTest extends TestCase {

    Consumption consumption = new Consumption();
    User user = new User();
    Food food = new Food();

    public void setUp() {
        food.setFoodId(5);
        user.setId(18);
    }

    public void testCreateConsumptionValid() {
        consumption.setAmount(9);
        consumption.setDate(LocalDateTime.now());
        consumption.setUser(user);
        consumption.setFood(food);

        assertTrue(ServiceConsumption.createConsumption(consumption));
    }

    public void testConsumptionsForCurrentUser() {
        user.setId(18);
        ArrayList<Consumption> consumptionsList = ServiceConsumption.getConsumptionsForCurrentUser(user);
        assertTrue(consumptionsList.size() >= 0);
    }
}