package com.peregrine.getfit.dao;

import java.util.ArrayList;

public interface IMySqlGenericDAO<T> {
    int create(T item);
    void update(T item);
    boolean delete(T item);
    T findById(Integer id);
    ArrayList<T> findAll();
}
