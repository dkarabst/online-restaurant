package com.softserve.academy.food.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import com.softserve.academy.food.entity.Category;

public class CategoryDAO
{

	private Query	queryResult;
	private Session	session;

	public CategoryDAO()
	{
		session = HibernateUtil.getSession();
	}

	public void addEntity(String name)
	{
		session.save(new Category(name));
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Category> getAllEntities()
	{
		queryResult = session.createQuery("from Category");
		session.flush();
		return (ArrayList<Category>) queryResult.list();
	}

	public void delEntityById(int id)
	{
		String hql = "DELETE FROM Category WHERE id ='" + id + "'";
		session.createQuery(hql).executeUpdate();
	}

	public void delEntityByName(String name)
	{
		String hql = "DELETE FROM Category WHERE name ='" + name + "'";
		session.createQuery(hql).executeUpdate();
	}

	public Category getEntityById(int id)
	{
		return (Category) session.get(Category.class, id);
	}

	public Category getEntityByName(String name)
	{
		queryResult = session.createQuery("from Category where name ='" + name
				+ "'");
		session.flush();
		return (Category) queryResult.list().get(0);

	}

}
