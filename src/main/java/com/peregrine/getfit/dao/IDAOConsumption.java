package com.peregrine.getfit.dao;

import com.peregrine.getfit.entities.Consumption;
import java.util.ArrayList;
/**
 * Интерфейс описывающий CRUD методы для классов DAOConsumption.
 */
public interface IDAOConsumption {
    boolean createConsumption(Consumption consumption);
    void update(Consumption consumption);
    boolean delete(Consumption consumption);
    ArrayList<Consumption> findAll();
}
