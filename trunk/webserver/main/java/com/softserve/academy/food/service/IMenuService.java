package com.softserve.academy.food.service;

import java.util.ArrayList;

import com.softserve.academy.food.model.CategoryModel;
import com.softserve.academy.food.model.DishModel;

public interface IMenuService {
	
	public ArrayList<DishModel> getAll();
	public ArrayList<DishModel> getAll( CategoryModel category );
	public DishModel get(int id);

}
