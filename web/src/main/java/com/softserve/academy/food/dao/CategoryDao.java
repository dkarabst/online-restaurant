package com.softserve.academy.food.dao;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softserve.academy.food.entity.Category;

@Repository("categoryDao")
public class CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDao() {
	}

	public void add(String name) {
		sessionFactory.getCurrentSession().save(new Category(name));
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

	public void delete(String name) {
		String hql = "DELETE FROM Category WHERE name ='" + name + "'";
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
	}

	public Category get(int id) {
		return (Category) sessionFactory.getCurrentSession().get(
				Category.class, id);
	}

	public Category get(String name) {
		return (Category) sessionFactory.getCurrentSession()
				.createQuery("from Category where name ='" + name + "'").list()
				.get(0);

	}

}
