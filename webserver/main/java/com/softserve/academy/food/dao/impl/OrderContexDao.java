package com.softserve.academy.food.dao.impl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softserve.academy.food.entity.OrderContents;

@Repository("orderContexDao")
public class OrderContexDao
{
	@Autowired
	private SessionFactory	sessionFactory;

	public OrderContents get(Integer id)
	{
		return (OrderContents) sessionFactory.getCurrentSession().get(
				OrderContents.class, id);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<OrderContents> getAll()
	{
		return (ArrayList<OrderContents>) sessionFactory.getCurrentSession()
				.createQuery("from OrderContents").list();
	}

	public void add( OrderContents order )
	{
		sessionFactory.getCurrentSession().save(order);
	}

}
