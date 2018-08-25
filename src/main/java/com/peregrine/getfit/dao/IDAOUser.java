package com.peregrine.getfit.dao;

import com.peregrine.getfit.entities.User;
import java.util.List;

public interface IDAOUser {
    int createUser(User user);
    void update(User user);
    boolean delete(User user);
    List<User> findAll();
}
