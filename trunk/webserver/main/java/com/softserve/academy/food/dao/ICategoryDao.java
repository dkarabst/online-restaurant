package com.softserve.academy.food.dao;

import java.util.ArrayList;

import com.softserve.academy.food.entity.Category;

public interface ICategoryDao {
	
	public void add( Category category );
	public ArrayList<Category> getAll();
	public void delete(int id);
	public Category get(int id);

}
