package com.softserve.academy.food.android;

import android.app.Application;
import com.softserve.academy.food.android.model.UserModel;

public class Role extends Application
{
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	private int currentRole = 2;
	
	private String login = "nobody";
	
	private UserModel userModel;

	public void setAdmin()
	{
		currentRole = 0;
	}

	public void setUser()
	{
		currentRole = 1;
	}

	public void setGuest()
	{
		currentRole = 2;
	}

	public boolean isAdmin()
	{
		return currentRole == 0;
	}

	public boolean isUser()
	{
		return currentRole == 1;
	}

	public boolean isGuest()
	{
		return currentRole == 2;
	}
}
