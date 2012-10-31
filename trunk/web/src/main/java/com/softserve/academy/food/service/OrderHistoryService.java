package com.softserve.academy.food.service;

import java.util.List;

import com.softserve.academy.food.model.OrderModel;

public interface OrderHistoryService
{

	public OrderModel getModelById(Integer id);

	public List<OrderModel> getAllModels();

	public void delModelById(Integer id);
}
