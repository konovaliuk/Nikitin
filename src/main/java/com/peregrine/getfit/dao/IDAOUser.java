package com.peregrine.getfit.dao;

import com.peregrine.getfit.entities.User;

import java.util.ArrayList;

/**
 * Интерфейс описывающий CRUD методы для классов DAOUser.
 */
public interface IDAOUser {
    int createUser(User user);
    int update(User user);
    boolean delete(User user);
    User findUserByEmail(String email);
    ArrayList<User> findAll();
}
