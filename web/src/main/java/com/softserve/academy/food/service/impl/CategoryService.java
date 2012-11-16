package com.softserve.academy.food.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.academy.food.dao.ICategoryDao;
import com.softserve.academy.food.entity.Category;
import com.softserve.academy.food.model.CategoryModel;
import com.softserve.academy.food.service.ICategoryService;

@Service("categoryService")
public class CategoryService implements ICategoryService
{
	@Autowired
	private ICategoryDao categoryDao;

	@Transactional
	public ArrayList<CategoryModel> getAll()
	{
		ArrayList<CategoryModel> models = new ArrayList<CategoryModel>();
		for (Category m : categoryDao.getAll())
		{
			models.add(m.toModel());
		}
		return models;
	}

	@Transactional
	public CategoryModel get(int id)
	{
		if ( categoryDao.get(id)!=null )
		{
			return categoryDao.get(id).toModel();
		}
		return new CategoryModel();
	}

	@Transactional
	public void add(CategoryModel category)
	{
		categoryDao.add( category.toEntity() );
	}

	@Transactional
	public void delete(int id)
	{
		categoryDao.delete(id);
	}


}