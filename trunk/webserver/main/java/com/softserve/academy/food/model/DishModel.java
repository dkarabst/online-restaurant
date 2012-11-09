package com.softserve.academy.food.model;

import com.softserve.academy.food.entity.Dish;

public class DishModel
{
	private int						id;
	private CategoryModel			category;
	private String					name;
	private Integer					price;
	private String					photo;
	private String					descr;
	private Character				avail;
	private Integer					prepTime;
	private String					weight;

	public DishModel()
	{
	}
	
	public DishModel( Dish dish )
	{
		id = dish.getId();
		category = dish.getCategory().toModel();
		name = dish.getName();
		price = dish.getPrice();
		photo = dish.getPhoto();
		descr = dish.getDescr();
		avail = dish.getAvail();
		prepTime = dish.getPrepTime();
		weight = dish.getWeight();
	}
	
	public Dish toEntity()
	{
		return new Dish( this );
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public CategoryModel getCategory()
	{
		return category;
	}

	public void setCategory(CategoryModel category)
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
	
	@Override
	public String toString()
	{
		return "Id = " + id + "; category = " + category + "; "
				+ "Name = " + name + "; Price = " + price + "; Photo = "
				+ photo + "; Description = " + descr + "; Availuable = "
				+ avail + "; Prepare Time = " + prepTime + "; Weight = "
				+ weight;
	}

}
