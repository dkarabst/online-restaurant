package com.softserve.academy.food.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import com.softserve.academy.food.entity.Category;
import com.softserve.academy.food.entity.Dish;

public class DishDAO
{

	protected Query		queryResult;
	protected Session	session;

	public DishDAO()
	{
		session = HibernateUtil.getSession();
		session.beginTransaction();
	}

	public Dish getEntityById(int id)
	{
//		Dish d = (Dish) session.get(Dish.class, id);
//		return new DishModel(d.getId(), d.getCategory(), d.getName(),
//				d.getPrice(), d.getPhoto(), d.getDescr(), d.getAvail(),
//				d.getPrepTime(), d.getWeight());
	    return (Dish) session.get(Dish.class, id);
	}

	public Dish getEntityByName(String name)
	{
		queryResult = session.createQuery("from DISHES where DISH_NAME ="
				+ name);
		session.flush();
//		@SuppressWarnings("unchecked")
//		List<Dish> entityList = queryResult.list();
//		ArrayList<DishModel> modelList = new ArrayList<DishModel>();
//		for (Dish d : entityList)
//		{
//			modelList.add(new DishModel(d.getId(), d.getCategory(),
//					d.getName(), d.getPrice(), d.getPhoto(), d.getDescr(), d
//							.getAvail(), d.getPrepTime(), d.getWeight()));
//		}
//		return modelList;
		return (Dish) queryResult.list().get(0);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Dish> getAllEntities()
	{
		queryResult = session.createQuery("from DISHES");
		session.flush();
//		@SuppressWarnings("unchecked")
//		List<Dish> entityList = queryResult.list();
//		ArrayList<DishModel> modelList = new ArrayList<DishModel>();
//		for (Dish d : entityList)
//		{
//			modelList.add(new DishModel(d.getId(), d.getCategory(),
//					d.getName(), d.getPrice(), d.getPhoto(), d.getDescr(), d
//							.getAvail(), d.getPrepTime(), d.getWeight()));
//		}
//		return modelList;
		return (ArrayList<Dish>) queryResult.list();
	}

	public void addEntity(Category category, String name, Integer price,
			String photo, String descr, Character avail, Integer prepTime,
			String weight)
	{
		session.save(new Dish(category, name, price, photo, descr, avail,
				prepTime, weight));
		session.flush();

	}

	public void delEntityById(int id)
	{
		String hql = "DELETE FROM DISHES WHERE dish_id =" + id;
		session.createQuery(hql);

	}

	public void delEntityByName(String name)
	{
		String hql = "DELETE FROM DISHES WHERE dish_name =" + name;
		session.createQuery(hql);
	}

}
