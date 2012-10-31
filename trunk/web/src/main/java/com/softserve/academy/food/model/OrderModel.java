package com.softserve.academy.food.model;

import java.util.Date;
import java.util.List;

import com.softserve.academy.food.entity.OrderSpec;
import com.softserve.academy.food.entity.User;

public class OrderModel
{
	private User user;
	private Date date;
	private Character status;
	private List <OrderSpec> spec;
	
	public OrderModel()
	{
	}

	public OrderModel(User user, Date date, Character status,List <OrderSpec> spec)
	{
		this.user = user;
		this.date = date;
		this.status = status;
		this.spec = spec;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
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

	public List<OrderSpec> getSpec()
	{
		return spec;
	}

	public void setSpec(List<OrderSpec> spec)
	{
		this.spec = spec;
	}
	
	
	
	

}
