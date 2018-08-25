package com.peregrine.getfit.dao;

import com.peregrine.getfit.entities.Food;
import java.util.ArrayList;

public interface IDAOFood {
    int create(Food food);
    void update(Food food);
    boolean delete(Food food);
    ArrayList<Food> findAll();
}
