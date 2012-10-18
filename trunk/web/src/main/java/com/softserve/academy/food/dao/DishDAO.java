package com.softserve.academy.food.dao;
//package com.hello.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.softserve.academy.food.entity.Dish;
import com.softserve.academy.food.model.DishModel;
import com.softserve.academy.food.model.IModel;

public class DishDAO
{
	
	protected Query		queryResult;
	protected Session	session;


	public IModel getModelById(int id)
	{
		queryResult = session.createQuery("from DISHES where dish_id =" + id);
		session.flush();
		Dish d = (Dish) queryResult.list().get(0);
		return new DishModel(d.getCategory(), d.getName(), d.getPrice(),
				d.getPhoto(), d.getDescr(), d.getAvail(), d.getPrepTime(),
				d.getWeight());
	}


	public IModel getModelByName(String name)
	{
		queryResult = session.createQuery("from DISHES where dish_id =" + name);
		session.flush();
		Dish d = (Dish) queryResult.list().get(0);
		return new DishModel(d.getCategory(), d.getName(), d.getPrice(),
				d.getPhoto(), d.getDescr(), d.getAvail(), d.getPrepTime(),
				d.getWeight());
	}

	public ArrayList<DishModel> getAllModels()
	{
		queryResult = session.createQuery("from DISHES");
		session.flush();
		@SuppressWarnings("unchecked")
		List<Dish> entityList = queryResult.list();
		DishModel model = null;
		ArrayList<DishModel> modelList = new ArrayList<DishModel>();
		for (Dish d : entityList)
		{
			model = new DishModel(d.getCategory(), d.getName(), d.getPrice(),
					d.getPhoto(), d.getDescr(), d.getAvail(), d.getPrepTime(),
					d.getWeight());
			modelList.add(model);
		}
		return modelList;
	}


	public void addModel(String name)
	{
		// TODO Auto-generated method stub

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
