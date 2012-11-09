package com.softserve.academy.food.dao;

import java.util.ArrayList;

import com.softserve.academy.food.entity.OrderContents;

public interface IOrderContexDao {
	
	public OrderContents get(Integer id);
	public ArrayList<OrderContents> getAll();
	public void add( OrderContents order );

}
