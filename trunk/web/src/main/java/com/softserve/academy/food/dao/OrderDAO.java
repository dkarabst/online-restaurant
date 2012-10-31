package com.softserve.academy.food.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softserve.academy.food.entity.OrderInfo;
import com.softserve.academy.food.entity.OrderSpec;
import com.softserve.academy.food.entity.User;

@Repository("orderDAO")
public class OrderDAO
{
	@Autowired
	private SessionFactory	sessionFactory;

	public OrderDAO()
	{
	}

	public OrderInfo getById(Integer id)
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

	public OrderInfo getByUser(User user)
	{
		return (OrderInfo) sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Orderinfo where user ='" + user.getId() + "'")
				.list().get(0);
	}

	public void add(User user, Date date, Character status,
			List<OrderSpec> spec)
	{
		sessionFactory.getCurrentSession().save(
				new OrderInfo(user, date, status, spec));

	}

	public void delById(Integer id)
	{
		String hql = "DELETE FROM ORDERINFO WHERE oinfo_id ='" + id + "'";
		sessionFactory.getCurrentSession().createQuery(hql);

	}

	public void delByUser(User user)
	{
		String hql = "DELETE FROM ORDERINFO WHERE OINFO_USER ='" + user.getId() + "'";
		sessionFactory.getCurrentSession().createQuery(hql);

	}

}
