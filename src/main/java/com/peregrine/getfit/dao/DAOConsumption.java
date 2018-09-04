package com.peregrine.getfit.dao;

import com.peregrine.getfit.entities.Consumption;
import com.peregrine.getfit.entities.Food;
import com.peregrine.getfit.entities.User;
import com.peregrine.getfit.util.DataSourceManager;

import java.sql.*;
import java.util.ArrayList;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DAOConsumption implements IDAOConsumption {
    private static Logger logger = LogManager.getLogger(DAOConsumption.class.getName());

    @Override
    public boolean createConsumption(Consumption consumption) {
        String sqlQuery = "insert into consumption(date, amount, user_user_id, food_food_id) values(?,?,?,?)";
        try(Connection connection = DataSourceManager.data().getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                statement.setTimestamp(1,Timestamp.valueOf(consumption.getDate()));
                statement.setInt(2,consumption.getAmount());
                statement.setInt(3,consumption.getUser().getId());
                statement.setInt(4,consumption.getFood().getFoodId());
                statement.executeUpdate();
            } catch (SQLException e) {
                connection.rollback();
                connection.setAutoCommit(true);
                logger.error("error occurred while creating a consumption" + e.getMessage());
            }
            connection.commit();
            connection.setAutoCommit(true);
            logger.info("consumption for : userId = " + consumption.getUser().getId() + "; and foodId = " + consumption.getFood().getFoodId() + " has been created");
            return true;
        } catch (SQLException e) {
            logger.error("error occurred while connecting to a database" + e.getMessage());
            return false;
        }
    }

    @Override
    public void update(Consumption consumption) {
        String sqlQuery = "update consumption Set date = ?, amount = ?, user_user_id = ?, food_food_id = ? where consumption_id = ?";
        try(Connection connection = DataSourceManager.data().getConnection()) {
           connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)){
                statement.setTimestamp(1,Timestamp.valueOf(consumption.getDate()));
                statement.setInt(2,consumption.getAmount());
                statement.setInt(3,consumption.getUser().getId());
                statement.setInt(4,consumption.getFood().getFoodId());
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
        ArrayList<Consumption> consumptionList = new ArrayList<>();
        String sqlQuery = "select consumption.*, food.*, user.* from consumption,food,user " +
                "where food_food_id = food_id and user_user_id = user_id";
        try(Connection connection = DataSourceManager.data().getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                ResultSet resultSet = statement.executeQuery(sqlQuery);
                while (resultSet.next()) {
                    Consumption consumption = new Consumption();
                    consumption.setConsumptionId(resultSet.getInt("consumption_id"));
                    consumption.setDate(resultSet.getTimestamp("date").toLocalDateTime());
                    consumption.setAmount(resultSet.getInt("amount"));
                    consumption.setUser(createUser(resultSet));
                    consumption.setFood(createFood(resultSet));
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

    private User createUser(ResultSet resultSet) {
        User user = new User();
        try {
            user.setId(resultSet.getInt("user_id"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setGender(resultSet.getString("gender").toLowerCase());
            user.setAge(resultSet.getInt("age"));
            user.setWeight(resultSet.getDouble("weight"));
            user.setHeight(resultSet.getDouble("height"));
            user.setLifestyle(resultSet.getString("lifestyle").toLowerCase());
            return user;
        } catch (SQLException e) {
            logger.error("error = " + e.getMessage());
            return null;
        }
    }

    private Food createFood(ResultSet resultSet) {
        Food food = new Food();
        try {
            food.setFoodId(resultSet.getInt("food_id"));
            food.setName(resultSet.getString("name"));
            food.setFat(resultSet.getDouble("fat"));
            food.setProtein(resultSet.getDouble("protein"));
            food.setCarb(resultSet.getDouble("carb"));
            food.setCalories(resultSet.getDouble("calories"));
            return food;
        } catch (SQLException e) {
            logger.error("error = " + e.getMessage());
            return null;
        }
    }
}
