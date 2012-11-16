package com.softserve.academy.food.dao.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.softserve.academy.food.dao.IDishDao;
import com.softserve.academy.food.entity.Category;
import com.softserve.academy.food.entity.Dish;

@Repository("dishDao")
public class DishDao extends Dao implements IDishDao
{
	public Dish get(int id)
	{
		return (Dish) session.getCurrentSession().get(Dish.class, id);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Dish> getAll()
	{
		return (ArrayList<Dish>) session.getCurrentSession()
				.createQuery("from Dish").list();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Dish> getAll( Category category )
	{
		return (ArrayList<Dish>) session.getCurrentSession()
				.createQuery("from Dish where CATEGORIES_cat_id = "+category.getId()).list();
	}

	public Dish add( Dish dish )
	{
		dish.setId((Integer)session.getCurrentSession().save(dish));
		return dish;
	}

	public void delete(int id)
	{
		Dish object = (Dish) session.getCurrentSession().load(
				Dish.class, id);
		if (null != object)
		{
			session.getCurrentSession().delete(object);
		}
	}


}
