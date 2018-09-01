package com.peregrine.getfit.dao;

import com.peregrine.getfit.entities.User;
import com.peregrine.getfit.util.DataSourceManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOUser implements IDAOUser {
    private static Logger logger = LogManager.getLogger(DAOUser.class.getName());

    @Override
    public int createUser(User user) {
        String sqlQuery = "insert into user(first_name,last_name,email,password,gender,age,weight,height,lifestyle) values(?,?,?,?,?,?,?,?,?)";
        int succsessValue = 0;
        try(Connection connection = DataSourceManager.data().getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                statement.setString(1,user.getFirstName());
                statement.setString(2,user.getLastName());
                statement.setString(3,user.getEmail());
                statement.setString(4,user.getPassword());
                statement.setString(5,user.getGender());
                statement.setInt(6,user.getAge());
                statement.setDouble(7,user.getWeight());
                statement.setDouble(8,user.getHeight());
                statement.setString(9,user.getLifestyle());

                succsessValue = statement.executeUpdate();
            }
            catch (SQLException e ) {
                connection.rollback();
                connection.setAutoCommit(true);
                logger.error("error occurred while creating a user" + e.getMessage());
            }
            connection.commit();
            connection.setAutoCommit(true);
            logger.info("user has been created");
        }
        catch (SQLException e) {
            logger.error("error occurred while connecting to a database" + e.getMessage());
        }
        return succsessValue;
    }

    @Override
    public User findUserByEmail(String email) {
        String sqlQuery = "Select * from user where email = ?";
        User user = new User();
        try (Connection connection = DataSourceManager.data().getConnection()) {
            connection.setAutoCommit(false);
            try ( PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                statement.setString(1,email);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
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
                }
            } catch (SQLException e) {
                connection.rollback();
                connection.setAutoCommit(true);
                logger.error("error occurred while finding user by id info; " + e.getMessage());
            }
            connection.commit();
            connection.setAutoCommit(true);
            logger.debug("user was found by email " + email);
        } catch (SQLException e) {
            logger.error("error occurred while connecting to a database" + e.getMessage());
        }
        return user;
    }

    @Override
    public ArrayList<User> findAll() {
        ArrayList<User> userList = new ArrayList<>();
        String sqlQuery = "select * from user";
        try(Connection connection = DataSourceManager.data().getConnection()) {
            connection.setAutoCommit(false);
            try(PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                ResultSet resultSet = statement.executeQuery(sqlQuery);
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("user_id"));
                    user.setFirstName(resultSet.getString("first_name"));
                    user.setLastName(resultSet.getString("last_name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    user.setGender(resultSet.getString("gender"));
                    user.setAge(resultSet.getInt("age"));
                    user.setWeight(resultSet.getDouble("weight"));
                    user.setHeight(resultSet.getDouble("height"));
                    user.setLifestyle(resultSet.getString("lifestyle"));
                    userList.add(user);
                    logger.info("all users have been found");
                }

            } catch (SQLException e) {
                connection.rollback();
                connection.setAutoCommit(true);
                logger.error("error occurred while finding all users' info; " + e.getMessage());
            }
            connection.commit();
            connection.setAutoCommit(true);
            logger.debug("all users have been found");
        } catch (SQLException e) {
            logger.error("error occurred while connecting to a database" + e.getMessage());
        }
        return userList;
    }

        @Override
    public void update(User user) {
        String sqlQuery = "update user Set first_name = ?, last_name = ?, email = ?, password = ?, gender = ?,age = ?, weight = ?, height = ?, lifestyle = ? where user_id = ?";
        try(Connection connection = DataSourceManager.data().getConnection()) {
            connection.setAutoCommit(false);
            try(PreparedStatement statement = connection.prepareStatement(sqlQuery)){
                statement.setString(1,user.getFirstName());
                statement.setString(2,user.getLastName());
                statement.setString(3,user.getEmail());
                statement.setString(4,user.getPassword());
                statement.setString(5,user.getGender());
                statement.setInt(6,user.getAge());
                statement.setDouble(7,user.getWeight());
                statement.setDouble(8,user.getHeight());
                statement.setString(9,user.getLifestyle());
                statement.setInt(10,user.getId());

                statement.executeUpdate();
            }
            catch (SQLException e) {
                connection.rollback();
                connection.setAutoCommit(true);
                logger.error("error occurred while updating user's info; " + e.getMessage());
            }
            connection.commit();
            connection.setAutoCommit(true);
            logger.info("user info has been modified");
        } catch (SQLException e) {
            logger.error("error occurred while connecting to a database" + e.getMessage());
        }
    }

    @Override
    public boolean delete(User user) {
        String sqlQuery = "delete from user where user_id = ?";
        boolean successfulExecute = false;
        try(Connection connection = DataSourceManager.data().getConnection()) {
            connection.setAutoCommit(false);
            try(PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                statement.setInt(1,user.getId());

                successfulExecute = statement.execute();
            } catch (SQLException e) {
                connection.rollback();
                connection.setAutoCommit(true);
                logger.error("error occurred while deleting a user; " + e.getMessage());
            }
            connection.commit();
            connection.setAutoCommit(true);
            logger.info("user with id" + user.getId() + " has been deleted");
        } catch (SQLException e) {
            logger.error("error occurred while connecting to a database" + e.getMessage());
            successfulExecute = false;
        }
        return successfulExecute;
    }
}
