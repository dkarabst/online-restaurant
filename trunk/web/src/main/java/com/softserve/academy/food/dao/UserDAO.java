package com.softserve.academy.food.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softserve.academy.food.entity.User;

@Repository("userDao")
public class UserDao {

	@Autowired
	private SessionFactory session;

	public User get(int id) {

		return (User) session.getCurrentSession().get(User.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		
		return (List<User>) session.getCurrentSession().createQuery("from User ").list();
	}
	
	@SuppressWarnings("unchecked")
	public User get(String name) {
		
		List<User> list = session.getCurrentSession().createQuery("from User where USER_NAME = '" + name + "'").list();

		if (list.isEmpty()) {
			
			return null;
		}
		return list.get(0);
	}

	public User add(User user) {
		
		user.setId( (Integer)session.getCurrentSession().save(user));
		
		return user;
	}

	public void delelete(int id) {

		Query query;
		query = session.getCurrentSession().createQuery("delete from User where id = " + id);
		query.executeUpdate();
	}
	
	public void delelete(User user) {

		 session.getCurrentSession().delete(user);
	}
	
	public void update(User user) {

		 session.getCurrentSession().update(user);
	}

}
