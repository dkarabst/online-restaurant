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
public class Category extends AbsEntity
{

	private static final long	serialVersionUID	= 1L;

	@Id
	@Column(name = "cat_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer				id;

	@Column(name = "CAT_NAME", length = 50)
	private String				name;

	// create table CATEGORIES (
	// CAT_ID integer,
	// CAT_NAME varchar(50)
	// )

	// insert into CATEGORIES (cat_id,
	// CAT_NAME)
	// values (?, ?)

	public Category()
	{
	}
	
	public CategoryModel toModel()
	{
		return new CategoryModel(id, name);
	}

	public Category(String name)
	{
		this.name = name;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Category))
			return false;
		Category other = (Category) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

} // Category