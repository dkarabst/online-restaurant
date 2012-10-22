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
		session.beginTransaction();
	}

	public void addEntity(String name)
	{
		session.save(new Category(name));
		session.flush();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Category> getAllEntities()
	{
		queryResult = session.createQuery("from Category");
		session.flush();
//		@SuppressWarnings("unchecked")
//		ArrayList<Category> entityList = (ArrayList<Category>) queryResult.list();
//		ArrayList<CategoryModel> modelList = new ArrayList<CategoryModel>();
//		for (Category entity : entityList)
//		{
//			modelList.add(new CategoryModel(entity.getId(),entity.getName()));
//		}
		return  (ArrayList<Category>) queryResult.list();
	}

	public void delEntityById(int id)
	{
		String hql = "DELETE FROM Category WHERE cat_id =" + id;
		session.createQuery(hql);
	}

	public void delEntityByName(String name)
	{
		String hql = "DELETE FROM Category WHERE cat_name =" + name;
		session.createQuery(hql);
	}

	public Category getEntityById(int id)
	{
		//Category cat = (Category) session.get(Category.class, id);
		//return new CategoryModel(cat.getId(),cat.getName());
	    return (Category) session.get(Category.class, id);
	}

	public Category getEntityByName(String name)
	{
		queryResult = session.createQuery("from Category where cat_name ="
				+ name);
		session.flush();
//		Category cat = (Category) queryResult.list().get(0);
		return (Category) queryResult.list().get(0);

	}

}
