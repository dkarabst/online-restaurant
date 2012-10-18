package com.softserve.academy.food.model;
//package com.hello.model;

public class CategoryModel implements IModel
{
	private String	name;

	public CategoryModel(String name)
	{
		this.name = name;
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
	public String toString()
	{
		return name;
	}
}