package com.peregrine.getfit.dao;

import com.peregrine.getfit.entities.Food;
import com.peregrine.getfit.util.DataSourceManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class DAOFood implements  IDAOFood {
    private static Logger logger = LogManager.getLogger(DAOFood.class.getName());
    @Override
    public int create(Food food) {
        String sqlQuery = "insert into food(name, fat, protein, carb, calories) values(?,?,?,?,?)";
        int succsessValue = 0;
        try(Connection connection = DataSourceManager.data().getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                statement.setString(1,food.getName());
                statement.setDouble(2,food.getFat());
                statement.setDouble(3,food.getProtein());
                statement.setDouble(4,food.getCarb());
                statement.setDouble(5,food.getCalories());

                succsessValue = statement.executeUpdate();

            } catch (SQLException e) {
                connection.rollback();
                connection.setAutoCommit(true);
                logger.error("error occurred while creating a food item " + e.getMessage());
            }
            connection.commit();
            connection.setAutoCommit(true);
            logger.info("food " + food.getFoodId() + " : " + food.getName() + " has been created");
        } catch (SQLException e) {
            logger.error("error occurred while connecting to a database" + e.getMessage());
        }
        return succsessValue;
    }

    @Override
    public void update(Food food) {
        String sqlQuery = "update food Set name = ?, fat = ?, protein = ?, carb = ?, calories = ? where food_id = ?";
        try(Connection connection = DataSourceManager.data().getConnection()) {
            connection.setAutoCommit(false);
            try(PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                statement.setString(1,food.getName());
                statement.setDouble(2,food.getFat());
                statement.setDouble(3,food.getProtein());
                statement.setDouble(4,food.getCarb());
                statement.setDouble(5,food.getCalories());

                statement.executeUpdate();

            } catch (SQLException e) {
                connection.rollback();
                connection.setAutoCommit(true);
                logger.error("error occurred while updating a food item " + e.getMessage());
            }
            connection.commit();
            connection.setAutoCommit(true);
            logger.info("food info has been modified");
        } catch (SQLException e) {
            logger.error("error occurred while connecting to a database" + e.getMessage());
        }
    }

    @Override
    public boolean delete(Food food) {
        String sqlQuery = "delete from food where food_id = ?";
        int rowsDeleted = 0;
        try(Connection connection = DataSourceManager.data().getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                statement.setInt(1,food.getFoodId());
                rowsDeleted = statement.executeUpdate();
            } catch (SQLException e) {
                connection.rollback();
                connection.setAutoCommit(true);
                logger.error("error occurred while deleting a food item " + e.getMessage());
            }
            connection.commit();
            connection.setAutoCommit(true);
            logger.info("food " + food.getName() + " with id " + food.getFoodId() + " was deleted");
        } catch (SQLException e) {
            logger.error("error occurred while connecting to a database" + e.getMessage());
        }
        if (rowsDeleted > 0) {
            return true;
        }
        return false;
    }

    public Food findFoodById(Integer id) {
        Food food = new Food();
        String sqlQuery = "select * from food where food_id = ?";
        try(Connection connection = DataSourceManager.data().getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                statement.setInt(1,id);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    food.setFoodId(resultSet.getInt("food_id"));
                    food.setName(resultSet.getString("name"));
                    food.setFat(resultSet.getDouble("fat"));
                    food.setProtein(resultSet.getDouble("protein"));
                    food.setCarb(resultSet.getDouble("carb"));
                    food.setCalories(resultSet.getDouble("calories"));
                }
            } catch (SQLException e) {
                connection.rollback();
                connection.setAutoCommit(true);
                logger.error("error occurred while finding a food item by id" + e.getMessage());
            }
            connection.commit();
            connection.setAutoCommit(true);
            logger.info("food with id = " + id + " has been found");

        } catch (SQLException e) {
            logger.error("error occurred while connecting to a database" + e.getMessage());
        }
        return food;
    }

    @Override
    public ArrayList<Food> findAll() {
        ArrayList<Food> foodList = new ArrayList<>();
        String sqlQuery = "select * from food";
        try(Connection connection = DataSourceManager.data().getConnection()) {
            connection.setAutoCommit(false);
            try ( PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                ResultSet resultSet = statement.executeQuery(sqlQuery);
                while (resultSet.next()) {
                    Food food = new Food();
                    food.setFoodId(resultSet.getInt("food_id"));
                    food.setName(resultSet.getString("name"));
                    food.setFat(resultSet.getDouble("fat"));
                    food.setProtein(resultSet.getDouble("protein"));
                    food.setCarb(resultSet.getDouble("carb"));
                    food.setCalories(resultSet.getDouble("calories"));
                    foodList.add(food);
                }
            } catch (SQLException e) {
                connection.rollback();
                connection.setAutoCommit(true);
                logger.error("error occurred while finding a food items" + e.getMessage());
            }
            connection.commit();
            connection.setAutoCommit(true);
            logger.info("all food have been found");
        } catch (SQLException e) {
            logger.error("error occurred while connecting to a database" + e.getMessage());
        }
        return foodList;
    }

}
