package com.softserve.academy.food.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.academy.food.dao.impl.OrderDao;
import com.softserve.academy.food.entity.Dish;
import com.softserve.academy.food.entity.OrderContents;
import com.softserve.academy.food.entity.OrderInfo;
import com.softserve.academy.food.entity.User;
import com.softserve.academy.food.model.OrderModel;

@Service("orderService")
public class OrderService
{
	@Autowired
	private OrderDao	orderDao;

	@Transactional
	public OrderModel get(int id)
	{
		return orderDao.get(id).toModel();
	}

	// working 
	//  but i dont realy understand what Status 4 ?  and where we will set it.
	@Transactional
	public void add(Integer user_id, ArrayList<Integer> spec)
	{
		User user = (User) session.getCurrentSession().get(User.class, user_id);
		List<OrderContents> list = new ArrayList<OrderContents>();
		for(int id : spec)
		{
			OrderContents oc = new OrderContents();
			Dish d = (Dish) session.getCurrentSession().get(Dish.class, id);
			oc.setDish(d);
			oc.setQuantity(1);
			list.add(oc);
		}
		orderDao.add(user, new Date(), 'A', list);
	}

	@Transactional
	public void delete(int id)
	{
		orderDao.delete(id);
	}

}
