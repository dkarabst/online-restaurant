package com.softserve.academy.food.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.softserve.academy.food.dao.CategoryDAO;
import com.softserve.academy.food.entity.Category;
import com.softserve.academy.food.model.CategoryModel;

public class CatService
{

	private static CategoryDAO	category	= new CategoryDAO();

	public static ArrayList<CategoryModel> getCategoryList()
	{
		ArrayList<CategoryModel> models = new ArrayList<CategoryModel>();
		for (Category m : category.getAllEntities())
		{
			models.add(m.toModel());
		}
		return models;
	}

	public static CategoryModel getById(int id)
	{
		return ((Category) category.getEntityById(id)).toModel();
	}

	public static CategoryModel getByName(String st)
	{
		return ((Category) category.getEntityByName(st)).toModel();
	}

	@Transactional
	public static void addCat(String name)
	{
		category.addEntity(name);
	}

	@Transactional
	public static void delById(int id)
	{
		category.delEntityById(id);
	}

	@Transactional
	public static void delByName(String name)
	{
		category.delEntityByName(name);
	}
}