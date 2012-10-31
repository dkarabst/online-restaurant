package com.softserve.academy.food.dao;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softserve.academy.food.entity.Category;

@Repository("categoryDAO")
public class CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDAO() {
	}

	public void addEntity(String name) {
		sessionFactory.getCurrentSession().save(new Category(name));
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Category> getAllEntities() {
		return (ArrayList<Category>) sessionFactory.getCurrentSession()
				.createQuery("from Category").list();
	}

	public void delEntityById(int id) {
		String hql = "DELETE FROM Category WHERE id ='" + id + "'";
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
	}

	public void delEntityByName(String name) {
		String hql = "DELETE FROM Category WHERE name ='" + name + "'";
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
	}

	public Category getEntityById(int id) {
		return (Category) sessionFactory.getCurrentSession().get(
				Category.class, id);
	}

	public Category getEntityByName(String name) {
		return (Category) sessionFactory.getCurrentSession()
				.createQuery("from Category where name ='" + name + "'").list()
				.get(0);

	}

}
