package com.peregrine.getfit.dao;


public class MySqlDAOFactory extends AbstractDAOFactory {
    public DAOUser getUserDAO() {
        return new DAOUser();
    }
    public DAOFood getFoodDAO() {
        return new DAOFood();
    }
    public DAOConsumption getConsumptionDAO() {
        return new DAOConsumption();
    }
}
