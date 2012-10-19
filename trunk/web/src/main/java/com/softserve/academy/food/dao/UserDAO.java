package com.softserve.academy.food.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.softserve.academy.food.entity.User;
import com.softserve.academy.food.model.IModel;
import com.softserve.academy.food.model.UserModel;

public class UserDAO
{
	protected Query		queryResult;
	protected Session	session;

	public UserDAO()
	{
		session = HibernateUtil.getSession();
		session.beginTransaction();
	}

	public IModel getModelById(int id)
	{
		User u = (User) session.get(User.class, id);
		return new UserModel(u.getId(), u.getName(), u.getEmail(),u.getPhone());
	}

	public List<UserModel> getAllModels()
	{
		queryResult = session.createQuery("from USERS ");
		session.flush();
		@SuppressWarnings("unchecked")
		List<User> entityList = queryResult.list();
		ArrayList<UserModel> modelList = new ArrayList<UserModel>();
		for (User entity : entityList)
		{
			modelList.add(new UserModel(entity.getId(), entity.getName(),
					entity.getEmail(),entity.getPhone()));
		}
		return modelList;
	}

	public List<UserModel> getModelByName(String name)
	{
		queryResult = session
				.createQuery("from USERS where USER_NAME =" + name);
		session.flush();
		@SuppressWarnings("unchecked")
		List<User> entityList = queryResult.list();
		ArrayList<UserModel> modelList = new ArrayList<UserModel>();
		for (User entity : entityList)
		{
			modelList.add(new UserModel(entity.getId(), entity.getName(),
					entity.getEmail(),entity.getPhone()));
		}
		return modelList;
	}

	public void addModel(String name, String email, String phone)
	{
		session.save(new User(name, email, phone));
		session.flush();
	}

	public void delModelById(int id)
	{
		String hql = "DELETE FROM USERS WHERE user_id =" + id;
		session.createQuery(hql);
	}
	
	public void delModelByPhone(String phone)
	{
		String hql = "DELETE FROM USERS WHERE USER_PHONE =" + phone;
		session.createQuery(hql);
	}

	public void delModelByNameAndEmail(String name, String email)
	{
		String hql = "DELETE FROM USERS WHERE USER_NAME =" + name
				+ "and USER_EMAIL=" + email;
		session.createQuery(hql);

	}

}