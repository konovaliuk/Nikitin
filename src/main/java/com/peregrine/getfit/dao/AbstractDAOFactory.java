package com.peregrine.getfit.dao;

public abstract class AbstractDAOFactory {

    public static final String MySql = "MySql";

    public abstract DAOUser getUserDAO();
    public abstract DAOFood getFoodDAO();
    public abstract DAOConsumption getConsumptionDAO();

    public static AbstractDAOFactory getDAOFactory(String whichFactory) {
        switch (whichFactory) {
            case MySql:
                return new MySqlDAOFactory();
            default:
                return null;
        }
    }
}
