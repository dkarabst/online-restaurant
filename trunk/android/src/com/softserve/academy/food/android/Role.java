package com.softserve.academy.food.android;

import android.app.Application;

public class Role extends Application
{
	private int currentRole = 2;

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
