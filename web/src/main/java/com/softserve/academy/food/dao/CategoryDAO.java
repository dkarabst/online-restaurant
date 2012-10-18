package com.softserve.academy.food.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.softserve.academy.food.entity.Category;
import com.softserve.academy.food.model.CategoryModel;
import com.softserve.academy.food.model.IModel;

public class CategoryDAO
{

	private Query	queryResult;
	private Session	session;

	public CategoryDAO()
	{
		session = HibernateUtil.getSession();
		session.beginTransaction();
	}

	public void addModel(String name)
	{
		session.save(new Category(name));
		session.flush();
	}

	public ArrayList<CategoryModel> getAllModels()
	{
		queryResult = session.createQuery("from Category");
		session.flush();
		@SuppressWarnings("unchecked")
		List<Category> entityList = queryResult.list();
		ArrayList<CategoryModel> modelList = new ArrayList<CategoryModel>();
		for (Category entity : entityList)
		{
			modelList.add(new CategoryModel(entity.getName()));
		}
		return modelList;
	}

	public void delModelById(int id)
	{
		String hql = "DELETE FROM Category WHERE cat_id =" + id;
		session.createQuery(hql);
	}

	public void delModelByName(String name)
	{
		String hql = "DELETE FROM Category WHERE cat_name =" + name;
		session.createQuery(hql);
	}

	public IModel getModelById(int id)
	{
		return new CategoryModel(
				((Category) session.get(Category.class, id)).getName());
	}

	public IModel getModelByName(String name)
	{
		queryResult = session.createQuery("from Category where cat_name ="
				+ name);
		session.flush();
		Category cat = (Category) queryResult.list().get(0);
		return new CategoryModel(cat.getName());

	}

}
