package com.softserve.academy.food.service;

import com.softserve.academy.food.dao.IUserDao;
import com.softserve.academy.food.model.UserCredentials;
import com.softserve.academy.food.model.UserModel;

public interface IUserService
{
	public void setUserDao(IUserDao userDao);
	
	public boolean checkUser(String login);
	public Boolean addUser(UserCredentials user);
	public UserModel getUser(int id);
	public void update(UserModel user);
}
