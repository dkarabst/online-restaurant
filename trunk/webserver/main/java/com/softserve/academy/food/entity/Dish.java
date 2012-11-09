package com.softserve.academy.food.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.softserve.academy.food.model.DishModel;

@Entity
@Table(name = "DISHES")
public class Dish extends AbstractEntity
{

	private static final long	serialVersionUID	= 1L;

	@Id
	@Column(name = "dish_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer				id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Category			category;

	@Column(name = "DISH_NAME", length = 50)
	private String				name;

	@Column(name = "DISH_PRICE")
	private Integer				price;

	@Column(name = "DISH_PHOTO", length = 50)
	private String				photo;

	@Column(name = "DISH_DESCR", length = 50)
	private String				descr;

	@Column(name = "DISH_AVAIL")
	private Character			avail;

	@Column(name = "DISH_PREP_TIME")
	private Integer				prepTime;

	@Column(name = "DISH_WEIGHT", length = 50)
	private String				weight;

	public Dish()
	{
	}

	public Dish( DishModel dish)
	{
		id = dish.getId();
		category = dish.getCategory().toEntity();
		name = dish.getName();
		price = dish.getPrice();
		photo = dish.getPhoto();
		descr = dish.getDescr();
		avail = dish.getAvail();
		prepTime = dish.getPrepTime();
		weight = dish.getWeight();

	}

	public DishModel toModel()
	{
		return new DishModel( this );
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avail == null) ? 0 : avail.hashCode());
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((descr == null) ? 0 : descr.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result
				+ ((prepTime == null) ? 0 : prepTime.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dish other = (Dish) obj;
		if (avail == null)
		{
			if (other.avail != null)
				return false;
		} else if (!avail.equals(other.avail))
			return false;
		if (category == null)
		{
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (descr == null)
		{
			if (other.descr != null)
				return false;
		} else if (!descr.equals(other.descr))
			return false;
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
		if (photo == null)
		{
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (prepTime == null)
		{
			if (other.prepTime != null)
				return false;
		} else if (!prepTime.equals(other.prepTime))
			return false;
		if (price == null)
		{
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (weight == null)
		{
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dish [id=" + id + ", category=" + category + ", name=" + name
				+ ", price=" + price + ", photo=" + photo + ", descr=" + descr
				+ ", avail=" + avail + ", prepTime=" + prepTime + ", weight="
				+ weight + "]";
	}
	
}