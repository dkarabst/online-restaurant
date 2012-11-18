package com.softserve.academy.food.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.softserve.academy.food.dao.IDishDao;
import com.softserve.academy.food.dao.IOrderDao;
import com.softserve.academy.food.dao.IUserDao;
import com.softserve.academy.food.entity.Category;
import com.softserve.academy.food.entity.Dish;
import com.softserve.academy.food.entity.User;
import com.softserve.academy.food.service.IOrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"beans.xml"})
public class OrderServiceTest 
{
	@Autowired
	private IOrderService oService;
	@Autowired
	private IDishDao dishDao;
	@Autowired
	private IOrderDao orderDao;
	@Autowired
	private IUserDao userDao;

	@Test
	public void testAdd() 
	{
		Dish dish = new Dish( "IceCream", new Category("Dessert") );
		dishDao.add( dish );
		
		userDao.add( new  User("guest", "1234") );
		
		Map<Integer,Integer> dishIdsToQuantities = new HashMap<Integer,Integer>();
		dishIdsToQuantities.put( 1, 2 );
		
		oService.add( dishIdsToQuantities );
		
	}
	//not working
}
