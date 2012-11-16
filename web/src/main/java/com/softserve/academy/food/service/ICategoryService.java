package com.softserve.academy.food.service;

import java.util.ArrayList;

import com.softserve.academy.food.model.CategoryModel;

public interface ICategoryService 
{
	public ArrayList<CategoryModel> getAll();
	public CategoryModel get( int id );
	public void add( CategoryModel category );
	public void delete( int id );
	
}
