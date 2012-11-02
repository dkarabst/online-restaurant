package com.softserve.academy.food.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softserve.academy.food.entity.OrderInfo;
import com.softserve.academy.food.entity.OrderContents;
import com.softserve.academy.food.entity.User;

@Repository("orderDao")
public class OrderDao
{
	@Autowired
	private SessionFactory	sessionFactory;

	public OrderDao()
	{
	}

	public OrderInfo get(Integer id)
	{
		return (OrderInfo) sessionFactory.getCurrentSession().get(
				OrderInfo.class, id);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<OrderInfo> getAll()
	{
		return (ArrayList<OrderInfo>) sessionFactory.getCurrentSession()
				.createQuery("from OrderInfo").list();
	}

	public void add(User user, Date date, Character status,
			List<OrderContents> spec)
	{
		OrderInfo oi = new OrderInfo(user, date, status, spec);
		for (OrderContents oc : spec)
		{
			oc.setOrderInfo(oi);
		}
		sessionFactory.getCurrentSession().save(oi);
	}

	public void delete(Integer id)
	{
		OrderInfo oi = (OrderInfo) sessionFactory.getCurrentSession().load(
				OrderInfo.class, id);
		if (null != oi)
		{
			sessionFactory.getCurrentSession().delete(oi);
		}
	}
}
