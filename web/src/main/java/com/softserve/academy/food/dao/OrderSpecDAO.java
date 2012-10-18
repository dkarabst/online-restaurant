package com.softserve.academy.food.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.softserve.academy.food.entity.Dish;
import com.softserve.academy.food.entity.OrderInfo;
import com.softserve.academy.food.entity.OrderSpec;
import com.softserve.academy.food.model.IModel;
import com.softserve.academy.food.model.OrderSpecModel;

public class OrderSpecDAO
{
	protected Query		queryResult;
	protected Session	session;

	public OrderSpecDAO()
	{
		session = HibernateUtil.getSession();
		session.beginTransaction();
	}

	public IModel getModelById(int id)
	{
		OrderSpec os = (OrderSpec) session.get(OrderSpec.class, id);
		return new OrderSpecModel(os.getOrderInfo(), os.getDish(),
				os.getQuantity());
	}

	public List<OrderSpecModel> getAllModels()
	{
		queryResult = session.createQuery("from ORDER_SPECS ");
		session.flush();
		@SuppressWarnings("unchecked")
		List<OrderSpec> entityList = queryResult.list();
		ArrayList<OrderSpecModel> modelList = new ArrayList<OrderSpecModel>();
		for (OrderSpec entity : entityList)
		{
			modelList.add(new OrderSpecModel(entity.getOrderInfo(), entity
					.getDish(), entity.getQuantity()));
		}
		return modelList;
	}

	public void addModel(OrderInfo orderInfo, Dish dish, Integer quantity)
	{
		session.save(new OrderSpec(orderInfo, dish, quantity));
		session.flush();
	}

	public void delModelById(int id)
	{
		String hql = "DELETE FROM ORDER_SPECS " + "WHERE ospec_id =" + id;
		session.createQuery(hql);

	}

}
