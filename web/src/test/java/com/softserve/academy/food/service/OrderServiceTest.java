package com.softserve.academy.food.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.softserve.academy.food.dao.DishDao;
import com.softserve.academy.food.dao.OrderDao;
import com.softserve.academy.food.dao.UserDao;
import com.softserve.academy.food.entity.Category;
import com.softserve.academy.food.entity.Dish;
import com.softserve.academy.food.entity.User;
import com.softserve.academy.food.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/service/beans.xml"})
public class OrderServiceTest 
{
	@Autowired
	private OrderService oService;
	@Autowired
	private DishDao dishDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private UserDao userDao;

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
