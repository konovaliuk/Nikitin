package com.peregrine.getfit.services;

import com.peregrine.getfit.dao.DAOFood;
import com.peregrine.getfit.entities.Food;
import junit.framework.TestCase;

import java.util.ArrayList;

public class ServiceFoodTest extends TestCase {

    Food food = new Food();

    public void testGetFoodList() {
        ArrayList<Food> foodList = ServiceFood.getFoodList();
        assertTrue(!foodList.isEmpty());
    }

    public void testAddFood() {
        food.setFoodId(9);
        food.setName("Pumpkin");
        food.setFat(45.6);
        food.setProtein(65.53);
        food.setCarb(12.4);
        food.setCalories(64.4);

        DAOFood daoFood = new DAOFood();
        ServiceFood.addFood(food);

        String name = food.getName();
        assertNotNull(name);
        Food newFood = daoFood.findFoodById(food.getFoodId());

        assertEquals("Pumpkin",newFood.getName());
        assertEquals(45.6, newFood.getFat());
        assertEquals(65.53, newFood.getProtein());

    }

    public void testFindFoodById() {
        Integer id = 3;
        Food foundFood = ServiceFood.findFoodById(id);

        assertEquals("cucumber", foundFood.getName());
        assertEquals(0.0,foundFood.getFat());
        assertEquals(0.1,foundFood.getProtein());
    }
}