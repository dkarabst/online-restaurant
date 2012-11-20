package com.softserve.academy.food.android.model;

public class CategoryModel
{
	private int id;
	private String name;
	private String photo;
	public boolean box;

	public CategoryModel()
	{}

	public CategoryModel(int id, String name)
	{
		this.id = id;
		this.name = name;
	}

	public CategoryModel(int id, String name, String photo, boolean box)
	{
		this.id = id;
		this.name = name;
		this.photo = photo;
		this.box = box;
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
	public String toString()
	{
		return "Категория - " + name;
	}

	public String getPhoto()
	{
		return photo;
	}

	public void setPhoto(String photo)
	{
		this.photo = photo;
	}

	public boolean isBox()
	{
		return box;
	}

	public void setBox(boolean box)
	{
		this.box = box;
	}

}
