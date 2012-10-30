package com.softserve.academy.food.service;

import com.softserve.academy.food.model.UserCredentials;
import com.softserve.academy.food.model.UserModel;

public interface iUserService 
{
	public boolean checkUser( String login );
	public void addUser(UserCredentials user);
	public UserModel getUser(int id);
	public void update( UserModel user );
}
