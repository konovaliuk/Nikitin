package com.peregrine.getfit.dao;

/**
 * Фабричный класс порождающий соответсвующие DAO классы
 */
public class MySqlDAOFactory extends AbstractDAOFactory {
    public IDAOUser getUserDAO() {
        return new DAOUser();
    }
    public IDAOFood getFoodDAO() {
        return new DAOFood();
    }
    public IDAOConsumption getConsumptionDAO() {
        return new DAOConsumption();
    }
}
