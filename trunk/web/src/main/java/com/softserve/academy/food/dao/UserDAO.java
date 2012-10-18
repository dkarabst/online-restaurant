package com.softserve.academy.food.dao;
//package com.hello.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.softserve.academy.food.entity.User;
import com.softserve.academy.food.model.IModel;
import com.softserve.academy.food.model.UserModel;

public class UserDAO
{
	protected Query	queryResult;
	protected Session	session;


	public IModel getModelById(int id)
	{
		queryResult = session.createQuery("from USERS where user_id ="+id);
		session.flush();
		User u = (User)queryResult.list().get(0); 
		return new UserModel(u.getName(),u.getEmail());
	}


	public IModel getModelByName(String name)
	{
		queryResult = session.createQuery("from USERS where USER_NAME ="+name);
		session.flush();
		User u = (User)queryResult.list().get(0); 
		return new UserModel(u.getName(),u.getEmail());
	}


	public void addModel(String name, String email)
	{
		String sql = "INSERT INTO USERS(USER_NAME,USER_EMAIL) values ('" + name + "','"+ email+"')";
		session.createSQLQuery(sql);
		session.flush();
	}


	public void delModelById(int id)
	{
		String hql = "DELETE FROM USERS WHERE user_id =" + id;
		session.createQuery(hql);
	}


	public void delModelByName(String name)
	{
		String hql = "DELETE FROM USERS WHERE USER_NAME ="+name;
		session.createQuery(hql);
		
	}

}
