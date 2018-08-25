package com.peregrine.getfit.dao;

import com.peregrine.getfit.entities.Consumption;
import com.peregrine.getfit.util.DataSourceManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



public class DAOConsumption implements IDAOConsumption {
    private static Logger logger = LogManager.getLogger(DAOConsumption.class.getName());
    @Override
    public int createConsumption(Consumption consumption) {
        String sqlQuery = "insert into consumption(time, amount, user_user_id, food_food_id) values(?,?,?,?)";
        int succsessValue = 0;
        try(Connection connection = DataSourceManager.data().getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                statement.setTime(1, (Time) consumption.getTime());
                statement.setInt(2,consumption.getAmount());
                statement.setInt(3,consumption.getUserId());
                statement.setInt(4,consumption.getFoodId());
                succsessValue = statement.executeUpdate();
            } catch (SQLException e) {
                connection.rollback();
                connection.setAutoCommit(true);
                logger.error("error occurred while creating a consumption" + e.getMessage());
            }
            connection.commit();
            connection.setAutoCommit(true);
            logger.info("consumption " + consumption.getConsumptionId() + " : userId = " + consumption.getUserId() +
                    "; foodId" + consumption.getFoodId() + " has been created");
        } catch (SQLException e) {
            logger.error("error occurred while connecting to a database" + e.getMessage());
        }
        return succsessValue;
    }

    @Override
    public void update(Consumption consumption) {
        String sqlQuery = "update consumption Set time = ?, amount = ?, user_user_id = ?, food_food_id = ? where consumption_id = ?";
        try(Connection connection = DataSourceManager.data().getConnection()) {
           connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)){
                statement.setDate(1,null);
                statement.setInt(2,consumption.getAmount());
                statement.setInt(3,consumption.getUserId());
                statement.setInt(4,consumption.getFoodId());
                statement.setInt(5,consumption.getConsumptionId());
                statement.executeUpdate();
            } catch (SQLException e) {
                connection.rollback();
                connection.setAutoCommit(true);
                logger.error("error occurred while updating a consumption" + e.getMessage());
            }
            connection.commit();
            connection.setAutoCommit(true);
            logger.info("consumption info has been modified");
        } catch (SQLException e) {
            logger.error("error occurred while connecting to a database" + e.getMessage());
        }
    }

    @Override
    public boolean delete(Consumption consumption) {
        String sqlQuery = "delete from consumption where consumption_id = ?";
        int rowsDeleted = 0;
        try(Connection connection = DataSourceManager.data().getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)){
                statement.setInt(1,consumption.getConsumptionId());
                rowsDeleted = statement.executeUpdate();
            } catch (SQLException e) {
                connection.rollback();
                connection.setAutoCommit(true);
                logger.error("error occurred while deleting a consumption" + e.getMessage());
            }
            connection.commit();
            connection.setAutoCommit(true);
            logger.info("consumption with id " + consumption.getConsumptionId() + " was deleted");
        } catch (SQLException e) {
            logger.error("error occurred while connecting to a database" + e.getMessage());
        }
        if (rowsDeleted > 0) {
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Consumption> findAll() {
        DAOFood food = new DAOFood();
        DAOUser user = new DAOUser();
        ArrayList<Consumption> consumptionList = new ArrayList<>();
        String sqlQuery = "select * from consumption";
        try(Connection connection = DataSourceManager.data().getConnection()) {
            connection.setAutoCommit(false);

            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                ResultSet resultSet = statement.executeQuery(sqlQuery);
                while (resultSet.next()) {
                    Consumption consumption = new Consumption();
                    consumption.setTime(new Date());
                    consumption.setAmount(resultSet.getInt("amount"));
                    consumption.setUserId(resultSet.getInt("user_user_id"));
                    consumption.setFoodId(resultSet.getInt("food_food_id"));
                    consumptionList.add(consumption);
                }
            } catch (SQLException e) {
                connection.rollback();
                connection.setAutoCommit(true);
                logger.error("error occurred in findAll consumption method " + e.getMessage());
            }
            connection.commit();
            connection.setAutoCommit(true);
            logger.info("all consumptions have been found");
        } catch (SQLException e) {
            logger.error("error occurred while connecting to a database" + e.getMessage());
        }
        return consumptionList;
    }
}
