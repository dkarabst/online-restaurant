package com.softserve.academy.food.service;

import com.softserve.academy.food.entity.User;

public interface UserService {

    public boolean isRegistered(String login);

    public Boolean add(User user);

    public User getUser(int id);

    public void update(User user);
}
