package com.softserve.academy.food.dao;

import java.util.ArrayList;
import java.util.List;


import com.softserve.academy.food.entity.Category;
import com.softserve.academy.food.entity.Dish;

public interface IDishDao {

	public Dish get(int id);
	public ArrayList<Dish> getAll( Category category );
	public List<Dish> getAll();
	public Dish add(Dish dish);
	public void delete(int id);

}
