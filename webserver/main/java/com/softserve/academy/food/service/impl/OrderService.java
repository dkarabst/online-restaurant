package com.softserve.academy.food.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.academy.food.dao.IDishDao;
import com.softserve.academy.food.dao.IOrderDao;
import com.softserve.academy.food.dao.IUserDao;
import com.softserve.academy.food.entity.Dish;
import com.softserve.academy.food.entity.OrderContents;
import com.softserve.academy.food.entity.OrderInfo;

@Service("orderService")
public class OrderService
{
	@Autowired
	@Qualifier("orderDao")
	private IOrderDao	orderDao;
	
	@Autowired
	@Qualifier("userDao")
	private IUserDao userDao;
	
	@Autowired
	@Qualifier("dishDao")
	private IDishDao dishDao;

	@Transactional
	public void add( String name, ArrayList<Integer> spec)
	{
		OrderInfo order = new OrderInfo(); 
		order.setUser( userDao.get(name) );
		order.setDate( new Date() );
		order.setStatus('A');
		
		List<OrderContents> orderInfo = new ArrayList<OrderContents>();
		
		for( int id : spec )
		{
			Dish dish = dishDao.get( id );
			orderInfo.add( new OrderContents(dish, 1, order) );
		}
		orderDao.add( order );
	}


}
