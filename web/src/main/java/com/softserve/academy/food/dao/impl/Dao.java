package com.softserve.academy.food.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.softserve.academy.food.dao.IDao;

public class Dao implements IDao
{
	@Autowired
	protected SessionFactory session;
	
	public void update( Object object )  
	{
		session.getCurrentSession().update( object );
	}

	public void delete( Object object )  
	{
		session.getCurrentSession().delete( object );
	}
	
	

}
