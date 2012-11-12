package com.softserve.academy.food.model;

import com.softserve.academy.food.entity.Dish;

public class DishModel
{
	private int						id;
	private CategoryModel			category;
	private String					name;
	private int					price;
	private String					photo;
	private String					descr;
	private Character				avail;
	private int					prepTime;
	private int						weight;

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

	public void setWeight( int weight )
	{
		this.weight = weight;
	}
	
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avail == null) ? 0 : avail.hashCode());
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((descr == null) ? 0 : descr.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + prepTime;
		result = prime * result + price;
		result = prime * result + weight;
		return result;
	}

	@Override
	public boolean equals( Object obj ) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DishModel))
			return false;
		DishModel other = (DishModel) obj;
		if (avail == null) {
			if (other.avail != null)
				return false;
		} else if (!avail.equals(other.avail))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (descr == null) {
			if (other.descr != null)
				return false;
		} else if (!descr.equals(other.descr))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (prepTime != other.prepTime)
			return false;
		if (price != other.price)
			return false;
		if (weight != other.weight)
			return false;
		return true;
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
