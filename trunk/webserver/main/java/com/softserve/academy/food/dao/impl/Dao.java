package com.softserve.academy.food.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.softserve.academy.food.dao.IDao;

public class Dao implements IDao
{
	@Autowired
	protected SessionFactory sessionFactory;
	
	public void update( Object object )  
	{
		sessionFactory.getCurrentSession().update( object );
	}

	public void delete( Object object )  
	{
		sessionFactory.getCurrentSession().delete( object );
	}
	
	

}
