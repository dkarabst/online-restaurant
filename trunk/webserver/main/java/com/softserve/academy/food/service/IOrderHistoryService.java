package com.softserve.academy.food.service;

import java.util.List;

import com.softserve.academy.food.model.OrderModel;

public interface IOrderHistoryService
{
	public OrderModel get( int id );
	public List<OrderModel> get( String login );

}
