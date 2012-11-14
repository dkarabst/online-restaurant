package com.softserve.academy.food.dao;

import java.util.List;

import com.softserve.academy.food.entity.Category;
import com.softserve.academy.food.entity.Dish;

public interface IDishDao extends IDao {

	public Dish get( int id );
	public List<Dish> getAll( Category category );
	public List<Dish> getAll();
	public Dish add(Dish dish);
	public void delete(int id);

}
