package com.softserve.academy.food.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.academy.food.dao.OrderDao;
import com.softserve.academy.food.entity.OrderInfo;
import com.softserve.academy.food.model.OrderModel;

@Service("orderHistoryService")
public class OrderHistoryServiceImpl implements OrderHistoryService
{

	@Autowired
	private OrderDao	orderDao;

	@Transactional
	public OrderModel getModelById(Integer id)
	{
		return orderDao.get(id).toModel();
	}

	@Transactional
	public List<OrderModel> getAllModels()
	{
		ArrayList<OrderModel> models = new ArrayList<OrderModel>();
		for (OrderInfo m : orderDao.getAll())
		{
			models.add(m.toModel());
		}
		return models;
	}

	@Transactional
	public void delModelById(Integer id)
	{
		orderDao.delete(id);
	}
}
