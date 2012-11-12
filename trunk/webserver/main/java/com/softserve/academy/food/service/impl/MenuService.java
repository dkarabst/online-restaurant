package com.softserve.academy.food.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.academy.food.dao.IDishDao;
import com.softserve.academy.food.entity.Dish;
import com.softserve.academy.food.model.CategoryModel;
import com.softserve.academy.food.model.DishModel;
import com.softserve.academy.food.service.IMenuService;

@Service("dishService")
public class MenuService implements IMenuService
{
	@Autowired
	@Qualifier("dishDao")
	private IDishDao dishDao;

	@Transactional
	public ArrayList<DishModel> getAll()
	{
		ArrayList<DishModel> models = new ArrayList<DishModel>();
		for (Dish m : dishDao.getAll())
		{
			models.add(m.toModel());
		}
		return models;
	}

	@Transactional
	public ArrayList<DishModel> getAll( CategoryModel category )
	{
		ArrayList<DishModel> models = new ArrayList<DishModel>();
		for (Dish dish : dishDao.getAll( category.toEntity() ))
		{
			models.add(dish.toModel());
		}
		return models;
	}
	
	@Transactional
	public DishModel get(int id)
	{
		if ( dishDao.get(id)!=null )
		{
			dishDao.get(id).toModel();
		}
		return new DishModel();
	}

	public void setDishDao(IDishDao dishDao) 
	{
		this.dishDao = dishDao;
	}
	
}
