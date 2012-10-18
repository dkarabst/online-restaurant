package com.softserve.academy.food.dao;
//package com.hello.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.softserve.academy.food.model.IModel;

public abstract class IDAO
{
	protected Query	queryResult;
	protected Session	session;
	
	public abstract IModel getModelById(int id);
	public abstract IModel getModelByName(String name);
	public abstract void addModel(String name);
	public abstract void delModelById(int id);
	public abstract void delModelByName(String name);

}
