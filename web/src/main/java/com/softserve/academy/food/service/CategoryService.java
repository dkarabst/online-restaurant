package com.softserve.academy.food.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.academy.food.dao.CategoryDao;
import com.softserve.academy.food.entity.Category;
import com.softserve.academy.food.model.CategoryModel;

@Service("categoryService")
public class CategoryService
{

	@Autowired
	private CategoryDao	categoryDao;

	@Transactional
	public ArrayList<CategoryModel> getCategoryList()
	{
		ArrayList<CategoryModel> models = new ArrayList<CategoryModel>();
		for (Category m : categoryDao.getAll())
		{
			models.add(m.toModel());
		}
		return models;
	}

	@Transactional
	public CategoryModel getById(int id)
	{
		return categoryDao.get(id).toModel();
	}

	@Transactional
	public CategoryModel getByName(String st)
	{
		return categoryDao.get(st).toModel();
	}

	@Transactional
	public void addCat(String name)
	{
		categoryDao.add(name);
	}

	@Transactional
	public void delById(int id)
	{
		categoryDao.delete(id);
	}

	@Transactional
	public void delByName(String name)
	{
		categoryDao.delete(name);
	}
}