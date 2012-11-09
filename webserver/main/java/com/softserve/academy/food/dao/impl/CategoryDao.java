package com.softserve.academy.food.dao.impl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softserve.academy.food.dao.ICategoryDao;
import com.softserve.academy.food.entity.Category;

@Repository("categoryDao")
public class CategoryDao implements ICategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void add( Category category ) {
		sessionFactory.getCurrentSession().save( category );
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Category> getAll() {
		return (ArrayList<Category>) sessionFactory.getCurrentSession()
				.createQuery("from Category").list();
	}

	public void delete(int id) {
		Category object = (Category) sessionFactory.getCurrentSession().load(
				Category.class, id);
		if (null != object)
		{
			sessionFactory.getCurrentSession().delete(object);
		}
	}

	public Category get(int id) {
		return (Category) sessionFactory.getCurrentSession().get(
				Category.class, id);
	}

}
