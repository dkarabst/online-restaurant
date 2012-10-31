package com.softserve.academy.food.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.academy.food.dao.OrderDAO;
import com.softserve.academy.food.entity.OrderInfo;
import com.softserve.academy.food.model.OrderModel;

@Service("orderHistoryService")
public class OrderHistoryServiceImpl implements OrderHistoryService
{

	@Autowired
	private OrderDAO	orderDAO;

	@Transactional
	public OrderModel getModelById(Integer id)
	{
		return orderDAO.getById(id).toModel();
	}

	@Transactional
	public List<OrderModel> getAllModels()
	{
		ArrayList<OrderModel> models = new ArrayList<OrderModel>();
		for (OrderInfo m : orderDAO.getAll())
		{
			models.add(m.toModel());
		}
		return models;
	}

	@Transactional
	public void delModelById(Integer id)
	{
		orderDAO.delById(id);
	}
}
