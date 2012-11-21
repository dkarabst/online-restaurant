package com.softserve.academy.food.service;

import com.softserve.academy.food.model.UserCredentials;
import com.softserve.academy.food.model.UserModel;

public interface IUserService {

    public boolean isRegistered(String login);

    public Boolean add(UserCredentials user);

    public UserModel getUser(int id);
    
    public UserModel getUser(String name);

    public void update(UserModel user);
}
