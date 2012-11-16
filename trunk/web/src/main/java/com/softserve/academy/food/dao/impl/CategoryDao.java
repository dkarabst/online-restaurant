package com.softserve.academy.food.dao.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.softserve.academy.food.dao.ICategoryDao;
import com.softserve.academy.food.entity.Category;

@Repository("categoryDao")
public class CategoryDao extends Dao implements ICategoryDao 
{

	public Category add( Category category ) 
	{
		category.setId( (Integer)session.getCurrentSession().save(category) );
		return category;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Category> getAll() {
		return (ArrayList<Category>) session.getCurrentSession()
				.createQuery("from Category").list();
	}
	
	public Category get(int id) {
		return (Category) session.getCurrentSession().get(
				Category.class, id);
	}

	public void delete(int id) {
		Category object = (Category) session.getCurrentSession().load(
				Category.class, id);
		if (null != object)
		{
			session.getCurrentSession().delete(object);
		}
	}

}
