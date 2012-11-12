package com.softserve.academy.food.model;

import com.softserve.academy.food.entity.Category;

public class CategoryModel
{
	private int		id;
	private String	name;

	public CategoryModel()
	{
	}
	
	public CategoryModel( String name )
	{
		this.name = name;
	}
	
	public CategoryModel( Category category )
	{
		id = category.getId();
		name = category.getName();
	}
	
	public Category toEntity()
	{
		return new Category( this );
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