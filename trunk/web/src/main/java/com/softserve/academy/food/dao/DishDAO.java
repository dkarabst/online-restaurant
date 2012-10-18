package com.softserve.academy.food.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.softserve.academy.food.entity.Category;
import com.softserve.academy.food.entity.Dish;
import com.softserve.academy.food.model.DishModel;
import com.softserve.academy.food.model.IModel;

public class DishDAO
{

	protected Query		queryResult;
	protected Session	session;

	public DishDAO()
	{
		session = HibernateUtil.getSession();
		session.beginTransaction();
	}

	public IModel getModelById(int id)
	{
		Dish d = (Dish) session.get(Dish.class, id);
		return new DishModel(d.getCategory(), d.getName(), d.getPrice(),
				d.getPhoto(), d.getDescr(), d.getAvail(), d.getPrepTime(),
				d.getWeight());
	}

	public ArrayList<DishModel> getModelByName(String name)
	{
		queryResult = session.createQuery("from DISHES where DISH_NAME =" + name);
		session.flush();
		@SuppressWarnings("unchecked")
		List<Dish> entityList = queryResult.list();
		ArrayList<DishModel> modelList = new ArrayList<DishModel>();
		for (Dish d : entityList)
		{
			modelList.add(new DishModel(d.getCategory(), d.getName(), d
					.getPrice(), d.getPhoto(), d.getDescr(), d.getAvail(), d
					.getPrepTime(), d.getWeight()));
		}
		return modelList;
	}

	public ArrayList<DishModel> getAllModels()
	{
		queryResult = session.createQuery("from DISHES");
		session.flush();
		@SuppressWarnings("unchecked")
		List<Dish> entityList = queryResult.list();
		ArrayList<DishModel> modelList = new ArrayList<DishModel>();
		for (Dish d : entityList)
		{
			modelList.add(new DishModel(d.getCategory(), d.getName(), d
					.getPrice(), d.getPhoto(), d.getDescr(), d.getAvail(), d
					.getPrepTime(), d.getWeight()));
		}
		return modelList;
	}

	public void addModel(Category category, String name, Integer price,
			String photo, String descr, Character avail, Integer prepTime,
			String weight)
	{
		session.save(new Dish(category, name, price, photo, descr, avail,
				prepTime, weight));
		session.flush();

	}

	public void delModelById(int id)
	{
		String hql = "DELETE FROM DISHES WHERE dish_id =" + id;
		session.createQuery(hql);

	}

	public void delModelByName(String name)
	{
		String hql = "DELETE FROM DISHES WHERE dish_name =" + name;
		session.createQuery(hql);
	}

}
