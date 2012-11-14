package com.softserve.academy.food.dao;

import java.util.List;

import com.softserve.academy.food.entity.Category;

public interface ICategoryDao {
	
	public Category add( Category category );
	public List<Category> getAll();
	public void delete(int id);
	public Category get(int id);

}
