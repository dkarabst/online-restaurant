package com.softserve.academy.food.android.model;

public class DishModel
{
	private int				id;
	private CategoryModel	category;
	private String			name;
	private int				price;
	private String			photo;
	private String			descr;
	private Character		avail;
	private int				prepTime;
	private int				weight;
	private boolean			box;

	public DishModel()
	{
	}

	@Override
	public String toString()
	{
		return "Id = " + id + "; category_id = " + category.getId() + "; "
				+ "Name = " + name + "; Price = " + price + "; Photo = "
				+ photo + "; Description = " + descr + "; Availuable = "
				+ avail + "; Prepare Time = " + prepTime + "; Weight = "
				+ weight;
	}

	public DishModel(int id, CategoryModel category, String name, int price,
			String photo, String descr, Character avail, int prepTime,
			int weight)
	{
		this.id = id;
		this.category = category;
		this.name = name;
		this.price = price;
		this.photo = photo;
		this.descr = descr;
		this.avail = avail;
		this.prepTime = prepTime;
		this.weight = weight;
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

	public int getPrice()
	{
		return price;
	}

	public void setPrice(int price)
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

	public int getPrepTime()
	{
		return prepTime;
	}

	public void setPrepTime(int prepTime)
	{
		this.prepTime = prepTime;
	}

	public int getWeight()
	{
		return weight;
	}

	public void setWeight(int weight)
	{
		this.weight = weight;
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
