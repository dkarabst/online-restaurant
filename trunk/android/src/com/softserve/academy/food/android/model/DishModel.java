package com.softserve.academy.food.android.model;

public class DishModel
{
	private int			id;
	private int			category_id;
	private String		name;
	private Integer		price;
	private String		photo;
	private String		descr;
	private Character	avail;
	private Integer		prepTime;
	private String		weight;
	public boolean box;

	public DishModel()
	{
	}

	@Override
	public String toString()
	{
		return "Id = " + id + "; category_id = " + category_id + "; "
				+ "Name = " + name + "; Price = " + price + "; Photo = "
				+ photo + "; Description = " + descr + "; Availuable = "
				+ avail + "; Prepare Time = " + prepTime + "; Weight = "
				+ weight;
	}

	public DishModel(int id, int category, String name, Integer price,
			String photo, String descr, Character avail, Integer prepTime,
			String weight, boolean box)
	{
		this.id = id;
		this.category_id = category;
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

	public int getCategory()
	{
		return category_id;
	}

	public void setCategory(int category)
	{
		this.category_id = category;
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
	public boolean isBox()
	{
		return box;
	}

	public void setBox(boolean box)
	{
		this.box = box;
	}
}
