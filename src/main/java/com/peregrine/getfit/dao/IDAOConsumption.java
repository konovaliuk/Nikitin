package com.peregrine.getfit.dao;

import com.peregrine.getfit.entities.Consumption;
import java.util.ArrayList;

public interface IDAOConsumption {
    int createConsumption(Consumption consumption);
    void update(Consumption consumption);
    boolean delete(Consumption consumption);
    ArrayList<Consumption> findAll();
}
