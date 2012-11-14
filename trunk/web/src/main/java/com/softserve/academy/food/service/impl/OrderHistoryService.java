package com.softserve.academy.food.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.academy.food.dao.IOrderDao;
import com.softserve.academy.food.entity.OrderInfo;
import com.softserve.academy.food.model.OrderModel;
import com.softserve.academy.food.service.IOrderHistoryService;

@Service("orderHistoryService")
public class OrderHistoryService implements IOrderHistoryService
{
	@Autowired
	@Qualifier("orderDao")
	private IOrderDao	orderDao;
	
	@Transactional
	public List<OrderModel> get( String login )
	{
		ArrayList<OrderModel> models = new ArrayList<OrderModel>();
		for (OrderInfo m : orderDao.getAll( login ))
		{
			models.add(m.toModel());
		}
		return models;
	}
	
	@Transactional
	public OrderModel get( int id )
	{
		return orderDao.get(id).toModel();
	}



}
