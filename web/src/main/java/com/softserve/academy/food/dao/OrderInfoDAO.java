package com.softserve.academy.food.dao;
//package com.hello.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;

import com.softserve.academy.food.entity.OrderInfo;
import com.softserve.academy.food.entity.User;
import com.softserve.academy.food.model.IModel;
import com.softserve.academy.food.model.OrderInfoModel;

public class OrderInfoDAO
{
	protected Query		queryResult;
	protected Session	session;

	public IModel getModelById(int id)
	{
		queryResult = session.createQuery("from ORDERINFO where oinfo_id ="
				+ id);
		session.flush();
		OrderInfo oi = (OrderInfo) queryResult.list().get(0);
		return new OrderInfoModel(oi.getUser(), oi.getDate(), oi.getStatus());
	}

	public void getModelByUser(String name)
	{
		// todo return model;
	}

	public void addModel(User user)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String sql = "INSERT INTO ORDERINFO(OINFO_USER,OINFO_DATE,OINFO_STATUS) values ('"
				+ user + "','" + dateFormat.format(date) + "','A')";
		session.createSQLQuery(sql);
		session.flush();

	}

	public void delModelById(int id)
	{
		String hql = "DELETE FROM ORDERINFO WHERE oinfo_id =" + id;
		session.createQuery(hql);

	}

	public void delModelByUser(String name)
	{
		// TODO Auto-generated method stub

	}

}
