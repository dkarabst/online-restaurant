package com.softserve.academy.food.dao;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softserve.academy.food.entity.Category;
import com.softserve.academy.food.entity.Dish;

@Repository("dishDAO")
public class DishDAO
{

	@Autowired
	private SessionFactory	sessionFactory;

	public DishDAO()
	{
	}

	public Dish getById(int id)
	{
		return (Dish) sessionFactory.getCurrentSession().get(Dish.class, id);
	}

	public Dish getByName(String name)
	{
		return (Dish) sessionFactory.getCurrentSession()
				.createQuery("from Dish where name ='" + name + "'").list()
				.get(0);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Dish> getAll()
	{
		return (ArrayList<Dish>) sessionFactory.getCurrentSession()
				.createQuery("from Dish").list();
	}

	public void add(Category category, String name, Integer price,
			String photo, String descr, Character avail, Integer prepTime,
			String weight)
	{
		sessionFactory.getCurrentSession().save(
				new Dish(category, name, price, photo, descr, avail, prepTime,
						weight));
	}

	public void delById(int id)
	{
		String hql = "DELETE FROM DISHES WHERE dish_id ='" + id + "'";
		sessionFactory.getCurrentSession().createQuery(hql);

	}

	public void delByName(String name)
	{
		String hql = "DELETE FROM DISHES WHERE dish_name ='" + name + "'";
		sessionFactory.getCurrentSession().createQuery(hql);
	}

}
