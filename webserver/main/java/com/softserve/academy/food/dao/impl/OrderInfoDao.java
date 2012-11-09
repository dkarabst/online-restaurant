package com.softserve.academy.food.dao.impl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softserve.academy.food.dao.IOrderInfoDao;
import com.softserve.academy.food.entity.OrderInfo;
import com.softserve.academy.food.entity.User;

@Repository("orderInfoDao")
public class OrderInfoDao implements IOrderInfoDao
{
	@Autowired
	private SessionFactory	sessionFactory;

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
	
	@SuppressWarnings("unchecked")
	public ArrayList<OrderInfo> getAll( String login )
	{
		User user = (User) sessionFactory.getCurrentSession().createQuery("from User where name ='"+login+"'").list().get(0);
		
		return (ArrayList<OrderInfo>) sessionFactory.getCurrentSession()
				.createQuery("from OrderInfo where USERS_user_id="+user.getId()).list();
	}

	public void add( OrderInfo order )
	{
		sessionFactory.getCurrentSession().save(order);
	}

}
