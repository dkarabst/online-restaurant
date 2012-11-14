package com.softserve.academy.food.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.academy.food.dao.impl.CategoryDao;
import com.softserve.academy.food.entity.Category;
import com.softserve.academy.food.model.CategoryModel;

@Service("categoryService")
public class CategoryService
{

	@Autowired
	private CategoryDao	categoryDao;

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
		return categoryDao.get(id).toModel();
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