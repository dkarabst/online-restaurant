package com.softserve.academy.food.dao;
//package com.hello.dao;

import org.hibernate.Query;
import org.hibernate.Session;



import com.softserve.academy.food.entity.OrderSpec;
import com.softserve.academy.food.model.IModel;
import com.softserve.academy.food.model.OrderSpecModel;

public class OrderSpecDAO
{
	protected Query	queryResult;
	protected Session	session;


	public IModel getModelById(int id)
	{
		queryResult = session.createQuery("from ORDER_SPECS where ospec_id =" + id);
		session.flush();
		OrderSpec os = (OrderSpec) queryResult.list().get(0);
		return new OrderSpecModel(os.getOrderInfo(),os.getDish(),os.getQuantity());
	}


	public IModel getModelByName(String name)
	{
		// TODO Auto-generated method stub
		return null;
	}


	public void addModel(String name)
	{
		// TODO Auto-generated method stub
		
	}


	public void delModelById(int id)
	{
		String hql = "DELETE FROM ORDER_SPECS " + "WHERE ospec_id =" + id;
		session.createQuery(hql);
		
	}


	public void delModelByName(String name)
	{
		// TODO Auto-generated method stub
		
	}

}
