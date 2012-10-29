package com.softserve.academy.food.dao;

import com.softserve.academy.food.entity.OrderInfo;
import com.softserve.academy.food.entity.OrderSpec;
import com.softserve.academy.food.entity.User;
import com.softserve.academy.food.model.IModel;
import com.softserve.academy.food.model.OrderModel;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDAO
{
	protected Query		queryResult;
	protected Session	session;

	public OrderDAO()
	{
		session = HibernateUtil.getSession();
		session.beginTransaction();
	}

	public IModel getModelById(Integer id)
	{
		OrderInfo oi = (OrderInfo) session.get(OrderInfo.class, id);
		return new OrderModel(oi.getUser(), oi.getDate(), oi.getStatus(),
				oi.getSpec());
	}
	
	public List<OrderModel> getAllModels()
	{
		queryResult = session.createQuery("from ORDERINFO ");
		session.flush();
		@SuppressWarnings("unchecked")
		List<OrderInfo> entityList = queryResult.list();
		ArrayList<OrderModel> modelList = new ArrayList<OrderModel>();
		for (OrderInfo entity : entityList)
		{
			modelList.add(new OrderModel(entity.getUser(),
					entity.getDate(), entity.getStatus(), entity.getSpec()));
		}
		return modelList;
	}

	public List<OrderModel> getModelByUser(User user)
	{
		queryResult = session.createQuery("from ORDERINFO where OINFO_USER ="
				+ user);
		session.flush();
		@SuppressWarnings("unchecked")
		List<OrderInfo> entityList = queryResult.list();
		ArrayList<OrderModel> modelList = new ArrayList<OrderModel>();
		for (OrderInfo entity : entityList)
		{
			modelList.add(new OrderModel(entity.getUser(),
					entity.getDate(), entity.getStatus(), entity.getSpec()));
		}
		return modelList;
	}

	public void addModel(User user, Date date, Character status,
			List<OrderSpec> spec)
	{
		session.save(new OrderInfo(user, date, status, spec));
		session.flush();

	}

	public void delModelById(Integer id)
	{
		String hql = "DELETE FROM ORDERINFO WHERE oinfo_id =" + id;
		session.createQuery(hql);

	}

	public void delModelByUser(User user)
	{
		String hql = "DELETE FROM ORDERINFO WHERE OINFO_USER =" + user;
		session.createQuery(hql);

	}

}
