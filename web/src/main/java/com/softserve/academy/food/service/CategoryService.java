package com.softserve.academy.food.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.academy.food.dao.CategoryDAO;
import com.softserve.academy.food.entity.Category;
import com.softserve.academy.food.model.CategoryModel;

@Service("categoryService")
public class CategoryService
{

	@Autowired
	private CategoryDAO	categoryDAO;

	@Transactional
	public ArrayList<CategoryModel> getCategoryList()
	{
		ArrayList<CategoryModel> models = new ArrayList<CategoryModel>();
		for (Category m : categoryDAO.getAllEntities())
		{
			models.add(m.toModel());
		}
		return models;
	}

	@Transactional
	public CategoryModel getById(int id)
	{
		return categoryDAO.getEntityById(id).toModel();
	}

	@Transactional
	public CategoryModel getByName(String st)
	{
		return categoryDAO.getEntityByName(st).toModel();
	}

	@Transactional
	public void addCat(String name)
	{
		categoryDAO.addEntity(name);
	}

	@Transactional
	public void delById(int id)
	{
		categoryDAO.delEntityById(id);
	}

	@Transactional
	public void delByName(String name)
	{
		categoryDAO.delEntityByName(name);
	}
}