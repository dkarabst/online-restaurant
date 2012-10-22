package com.softserve.academy.food.service;

import java.util.ArrayList;

import com.softserve.academy.food.dao.CategoryDAO;
import com.softserve.academy.food.entity.Category;

public class CatService
{

	CategoryDAO	category	= new CategoryDAO();

	public ArrayList<String> getCategoryList()
	{

		ArrayList<Category> mList = category.getAllEntities();
		mList.remove(0); // remove category "Вне категории"
		ArrayList<String> sList = new ArrayList<String>();
		for (Category m : mList)
		{
			sList.add(m.getName());
		}
		return sList;
	}

	public String getById(int id)
	{
		return ((Category) category.getEntityById(id)).getName();
	}

	public String getByName(String st)
	{
		return ((Category) category.getEntityByName(st)).getName();
	}

	public void addCat(String name)
	{
		category.addEntity(name);
	}

	public void delById(int id)
	{
		category.delEntityById(id);
	}

	public void delByName(String name)
	{
		category.delEntityByName(name);
	}
}