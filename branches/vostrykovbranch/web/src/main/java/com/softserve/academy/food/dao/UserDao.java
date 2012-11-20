package com.softserve.academy.food.dao;

import com.softserve.academy.food.entity.User;

import java.util.List;

public interface UserDao extends Dao {

    public List<User> getAll();

    public User getByName(String name);
    public User getById(int id);    
    public User add(User user);
    public void delete(int id);

}
