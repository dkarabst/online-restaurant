package com.softserve.academy.food.model;

import com.softserve.academy.food.entity.Category;

public class CategoryModel
{
	private int		id;
	private String	name;

	public CategoryModel()
	{
	}
	
	public CategoryModel(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public Category toEntity()
	{
		return new Category(id, name);
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString() {
		return "CategoryModel [id=" + id + ", name=" + name + "]";
	}


}