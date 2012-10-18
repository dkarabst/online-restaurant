package com.softserve.academy.food.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.softserve.academy.food.entity.OrderInfo;
import com.softserve.academy.food.entity.OrderSpec;
import com.softserve.academy.food.entity.User;
import com.softserve.academy.food.model.IModel;
import com.softserve.academy.food.model.OrderInfoModel;

public class OrderInfoDAO
{
	protected Query		queryResult;
	protected Session	session;

	public OrderInfoDAO()
	{
		session = HibernateUtil.getSession();
		session.beginTransaction();
	}

	public IModel getModelById(int id)
	{
		OrderInfo oi = (OrderInfo) session.get(OrderInfo.class, id);
		return new OrderInfoModel(oi.getUser(), oi.getDate(), oi.getStatus(),
				oi.getSpec());
	}
	
	public List<OrderInfoModel> getAllModels()
	{
		queryResult = session.createQuery("from ORDERINFO ");
		session.flush();
		@SuppressWarnings("unchecked")
		List<OrderInfo> entityList = queryResult.list();
		ArrayList<OrderInfoModel> modelList = new ArrayList<OrderInfoModel>();
		for (OrderInfo entity : entityList)
		{
			modelList.add(new OrderInfoModel(entity.getUser(),
					entity.getDate(), entity.getStatus(), entity.getSpec()));
		}
		return modelList;
	}

	public List<OrderInfoModel> getModelByUser(User user)
	{
		queryResult = session.createQuery("from ORDERINFO where OINFO_USER ="
				+ user);
		session.flush();
		@SuppressWarnings("unchecked")
		List<OrderInfo> entityList = queryResult.list();
		ArrayList<OrderInfoModel> modelList = new ArrayList<OrderInfoModel>();
		for (OrderInfo entity : entityList)
		{
			modelList.add(new OrderInfoModel(entity.getUser(),
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

	public void delModelById(int id)
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
