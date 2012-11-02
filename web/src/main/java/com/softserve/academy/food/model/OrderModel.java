package com.softserve.academy.food.model;

import java.util.Date;
import java.util.List;

public class OrderModel
{
	private int					user_id;
	private Date				date;
	private Character			status;
	private List<ContentModel>	spec;

	public OrderModel()
	{
	}

	@Override
	public String toString()
	{
		return "User: " + user_id + " Date: " + date + " Status: " + status
				+ " Content: " + spec.toString();
	}

	public OrderModel(int user_id, Date date, Character status,
			List<ContentModel> spec)
	{
		super();
		this.user_id = user_id;
		this.date = date;
		this.status = status;
		this.spec = spec;
	}

	public int getUser_id()
	{
		return user_id;
	}

	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public Character getStatus()
	{
		return status;
	}

	public void setStatus(Character status)
	{
		this.status = status;
	}

	public List<ContentModel> getSpec()
	{
		return spec;
	}

	public void setSpec(List<ContentModel> spec)
	{
		this.spec = spec;
	}
}
