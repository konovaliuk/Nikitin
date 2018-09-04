package com.peregrine.getfit.services;

import com.peregrine.getfit.entities.Consumption;
import com.peregrine.getfit.entities.Food;
import com.peregrine.getfit.entities.User;
import junit.framework.TestCase;

import java.util.ArrayList;

public class ServiceCalculateCaloriesTest extends TestCase {
    ServiceCalculateCalories caloriesCalculator = new ServiceCalculateCalories();
    ArrayList<Consumption> consumptionsList = new ArrayList<>();
    User userMale = new User();
    User userFemale = new User();
    Food food = new Food();
    Consumption consumption = new Consumption();

    public void setUp() {
        food.setFoodId(6);
        food.setName("Candy");
        food.setFat(100.0);
        food.setProtein(10.0);
        food.setCarb(100.0);
        food.setCalories(50.0);

        userMale.setAge(25);
        userMale.setWeight(87.0);
        userMale.setHeight(185.0);
        userMale.setGender("male");


        userFemale.setAge(20);
        userFemale.setWeight(50.0);
        userFemale.setHeight(168.0);
        userFemale.setGender("female");

        consumption.setFood(food);
        consumption.setConsumptionId(1);
    }

    public void testCaloriesNormLowerMale() {
        userMale.setLifestyle("low");
        consumption.setAmount(10);
        consumption.setUser(userMale);
        consumptionsList.add(consumption);

        String verdict = caloriesCalculator.caloriesNorm(userMale,consumptionsList);
        assertEquals("lower", verdict);
    }

    public void testCaloriesNormOverMale() {
        userMale.setLifestyle("low");
        consumption.setAmount(100);
        consumption.setUser(userMale);
        consumptionsList.add(consumption);

        String verdict = caloriesCalculator.caloriesNorm(userMale,consumptionsList);
        assertEquals("over", verdict);
    }

    public void testCaloriesNormNormalMale() {
        userMale.setLifestyle("low");
        consumption.setAmount(47);
        consumption.setUser(userMale);
        consumptionsList.add(consumption);

        String verdict = caloriesCalculator.caloriesNorm(userMale,consumptionsList);
        System.out.println(verdict);
        assertEquals("norm", verdict);
    }

    public void testCaloriesNormNormalFemale() {
        userFemale.setLifestyle("high");
        consumption.setAmount(50);
        consumption.setUser(userFemale);
        consumptionsList.add(consumption);

        String verdict = caloriesCalculator.caloriesNorm(userFemale,consumptionsList);
        System.out.println(verdict);
        assertEquals("norm", verdict);
    }

    public void testCaloriesNormNormalLazyFemale() {
        userFemale.setLifestyle("minimum");
        consumption.setAmount(38);
        consumption.setUser(userFemale);
        consumptionsList.add(consumption);

        String verdict = caloriesCalculator.caloriesNorm(userFemale,consumptionsList);
        System.out.println(verdict);
        assertEquals("norm", verdict);
    }

    public void testCaloriesNormNormalMedumActiveFemale() {
        userFemale.setLifestyle("medium");
        consumption.setAmount(45);
        consumption.setUser(userFemale);
        consumptionsList.add(consumption);

        String verdict = caloriesCalculator.caloriesNorm(userFemale,consumptionsList);
        System.out.println(verdict);
        assertEquals("norm", verdict);
    }

    public void testCaloriesNormNormalVeryActiveFemale() {
        userFemale.setLifestyle("very high");
        consumption.setAmount(53);
        consumption.setUser(userFemale);
        consumptionsList.add(consumption);

        String verdict = caloriesCalculator.caloriesNorm(userFemale,consumptionsList);
        System.out.println(verdict);
        assertEquals("norm", verdict);
    }

    public void testCaloriesNormNormalDefault() {
        userFemale.setLifestyle("jiberish");
        consumption.setAmount(26);
        consumption.setUser(userFemale);
        consumptionsList.add(consumption);

        String verdict = caloriesCalculator.caloriesNorm(userFemale,consumptionsList);
        System.out.println(verdict);
        assertEquals("norm", verdict);
    }
}