package com.softserve.academy.food.model;
//package com.hello.model;

public class UserModel implements IModel
{
	private String name;
	private String email;
	
	public UserModel()
	{
	}

	public UserModel(String name, String email)
	{
		super();
		this.name = name;
		this.email = email;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
	
	

}
