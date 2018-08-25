package com.peregrine.getfit.entities;

import java.io.Serializable;
import java.util.Objects;

public class Food implements Serializable {
    private Integer foodId;
    private String name;
    private Double fat;
    private Double protein;
    private Double carb;
    private Double calories;

    public Food() {}

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getCarb() {
        return carb;
    }

    public void setCarb(Double carb) {
        this.carb = carb;
    }

    public Double getCalories() { return calories; }

    public void setCalories(Double calories) { this.calories = calories; }

    //TODO: пересмотреть hashCode() и equals();
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Objects.equals(foodId, food.foodId) &&
                Objects.equals(name, food.name) &&
                Objects.equals(fat, food.fat) &&
                Objects.equals(protein, food.protein) &&
                Objects.equals(carb, food.carb) &&
                Objects.equals(calories, food.calories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodId, name, fat, protein, carb, calories);
    }

    @Override
    public String toString() {
        return "Food(" +
                "foodId=" + foodId +
                ", name='" + name + '\'' +
                ", fat=" + fat +
                ", protein=" + protein +
                ", carb=" + carb +
                ", calories=" + calories +
                ')';
    }
}