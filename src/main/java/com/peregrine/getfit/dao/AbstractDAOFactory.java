package com.peregrine.getfit.dao;

/**
 * Фабричный класс порождающий фабрики с разным видом SQL.
 */
public abstract class AbstractDAOFactory {

    public static final String MySql = "MySql";

    public abstract IDAOUser getUserDAO();
    public abstract IDAOFood getFoodDAO();
    public abstract IDAOConsumption getConsumptionDAO();

    /**
     * Получение фабрики DAO
     * @param whichFactory Строка для выбора фабрики: MySQL, PostgreSQL...
     * @return
     */
    public static AbstractDAOFactory getDAOFactory(String whichFactory) {
        switch (whichFactory) {
            case MySql:
                return new MySqlDAOFactory();
            default:
                return null;
        }
    }
}
