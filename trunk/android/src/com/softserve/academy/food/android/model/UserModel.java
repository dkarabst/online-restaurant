package com.softserve.academy.food.android.model;

public class UserModel
{
	private int		id;
	private String	email;
	private String	phone;
	
	@Override
	public String toString()
	{
		return "\n \n \n" +
				"Email :"+email+"\n \n"+
				"Phone :"+phone;
	}
	
	public UserModel()
	{
	}

	public UserModel(int id, String email, String phone)
	{
		this.id = id;
		this.email = email;
		this.phone = phone;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

}
