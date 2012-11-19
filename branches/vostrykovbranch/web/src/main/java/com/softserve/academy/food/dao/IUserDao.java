package com.softserve.academy.food.dao;

import com.softserve.academy.food.entity.User;

import java.util.List;

public interface IUserDao extends IDao {

    public User get(int id);

    public List<User> getAll();

    public User get(String name);

    public User add(User user);

    public void delete(int id);

}
