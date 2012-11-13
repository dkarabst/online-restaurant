package com.softserve.academy.food.dao;

import java.util.List;

import com.softserve.academy.food.entity.OrderInfo;

public interface IOrderDao 
{
	public OrderInfo get(Integer id);
	public List<OrderInfo> getAll();
	public void add( OrderInfo order );
	public List<OrderInfo> getAll( String login );

}
