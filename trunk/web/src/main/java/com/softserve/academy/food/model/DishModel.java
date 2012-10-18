package com.softserve.academy.food.model;
//package com.hello.model;

import com.softserve.academy.food.entity.Category;

public class DishModel implements IModel
{
	private Category	category;
	private String		name;
	private Integer		price;
	private String		photo;
	private String		descr;
	private Character	avail;
	private Integer		prepTime;
	private String		weight;

	public DishModel()
	{
	}

	public DishModel(Category category, String name, Integer price,
			String photo, String descr, Character avail, Integer prepTime,
			String weight)
	{
		this.category = category;
		this.name = name;
		this.price = price;
		this.photo = photo;
		this.descr = descr;
		this.avail = avail;
		this.prepTime = prepTime;
		this.weight = weight;
	}

	public Category getCategory()
	{
		return category;
	}

	public void setCategory(Category category)
	{
		this.category = category;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getPrice()
	{
		return price;
	}

	public void setPrice(Integer price)
	{
		this.price = price;
	}

	public String getPhoto()
	{
		return photo;
	}

	public void setPhoto(String photo)
	{
		this.photo = photo;
	}

	public String getDescr()
	{
		return descr;
	}

	public void setDescr(String descr)
	{
		this.descr = descr;
	}

	public Character getAvail()
	{
		return avail;
	}

	public void setAvail(Character avail)
	{
		this.avail = avail;
	}

	public Integer getPrepTime()
	{
		return prepTime;
	}

	public void setPrepTime(Integer prepTime)
	{
		this.prepTime = prepTime;
	}

	public String getWeight()
	{
		return weight;
	}

	public void setWeight(String weight)
	{
		this.weight = weight;
	}

}
