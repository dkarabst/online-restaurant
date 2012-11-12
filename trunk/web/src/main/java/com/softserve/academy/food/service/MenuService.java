package com.softserve.academy.food.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.academy.food.dao.DishDao;
import com.softserve.academy.food.entity.Category;
import com.softserve.academy.food.entity.Dish;
import com.softserve.academy.food.model.CategoryModel;
import com.softserve.academy.food.model.DishModel;

@Service("dishService")
public class MenuService
{
	@Autowired
	private DishDao	dishDao;

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
		for (Dish m : dishDao.getAll(category.getId()))
		{
			models.add(m.toModel());
		}
		return models;
	}

	@Transactional
	public DishModel get(int id)
	{
		return dishDao.get(id).toModel();
	}

	@Transactional
	public DishModel get(String st)
	{
		return dishDao.get(st).toModel();
	}

	@Transactional
	public void add(Category category, String name, Integer price,
			String photo, String descr, Character avail, Integer prepTime,
			String weight)
	{
		dishDao.add(category, name, price, photo, descr, avail, prepTime,
				weight);
	}

	@Transactional
	public void delete(int id)
	{
		dishDao.delete(id);
	}

	@Transactional
	public void delete(String name)
	{
		dishDao.delete(name);
	}
}
