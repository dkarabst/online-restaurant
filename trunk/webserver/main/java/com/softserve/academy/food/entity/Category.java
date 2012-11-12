package com.softserve.academy.food.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.softserve.academy.food.model.CategoryModel;

@Entity
@Table(name = "CATEGORIES")
public class Category 
{
	@Id
	@Column(name = "cat_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int				id;

	@Column(name = "CAT_NAME", length = 50)
	private String				name;

	public Category()
	{
	}
	
	public Category( CategoryModel category )
	{
		id = category.getId();
		name = category.getName();
	}
	
	public CategoryModel toModel()
	{
		return new CategoryModel( this );
	}

	public Category( String name )
	{
		this.name = name;
	}

	public int getId()
	{
		return id;
	}

	public void setId( int id )
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
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Category))
			return false;
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return "Category [id=" + id + ", name=" + name + "]";
	}
	

}