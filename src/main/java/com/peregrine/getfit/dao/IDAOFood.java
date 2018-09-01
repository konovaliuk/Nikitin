package com.peregrine.getfit.dao;

import com.peregrine.getfit.entities.Food;
import java.util.ArrayList;

/**
 * Интерфейс описывающий CRUD методы для классов DAOFood.
 */

public interface IDAOFood {
    int create(Food food);
    void update(Food food);
    boolean delete(Food food);
    Food findFoodById(Integer id);
    ArrayList<Food> findAll();
}
