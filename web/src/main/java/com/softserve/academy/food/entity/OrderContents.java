package com.softserve.academy.food.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.softserve.academy.food.model.ContentModel;

@Entity
@Table(name = "ORDERSPEC")
public class OrderContents extends AbstractEntity
{

	private static final long	serialVersionUID	= 1L;

	@Id
	@Column(name = "ospec_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer				id;

	@ManyToOne(fetch = FetchType.LAZY)
	private OrderInfo			orderInfo;

	@ManyToOne(fetch = FetchType.LAZY)
	private Dish				dish;

	@Column(name = "OSPEC_QUANTITY")
	private Integer				quantity;

	public OrderContents()
	{
	}

	public ContentModel toModel()
	{
		return new ContentModel(id, orderInfo.getId(), dish.toModel(), quantity);
	}

	public OrderContents(OrderInfo orderInfo, Dish dish, Integer quantity)
	{
		setOrderInfo(orderInfo);
		setDish(dish);
		setQuantity(quantity);
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public OrderInfo getOrderInfo()
	{
		return orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo)
	{
		this.orderInfo = orderInfo;
	}

	public Dish getDish()
	{
		return dish;
	}

	public void setDish(Dish dish)
	{
		this.dish = dish;
	}

	public Integer getQuantity()
	{
		return quantity;
	}

	public void setQuantity(Integer quantity)
	{
		this.quantity = quantity;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dish == null) ? 0 : dish.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((orderInfo == null) ? 0 : orderInfo.hashCode());
		result = prime * result
				+ ((quantity == null) ? 0 : quantity.hashCode());
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
		OrderContents other = (OrderContents) obj;
		if (dish == null)
		{
			if (other.dish != null)
				return false;
		} else if (!dish.equals(other.dish))
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderInfo == null)
		{
			if (other.orderInfo != null)
				return false;
		} else if (!orderInfo.equals(other.orderInfo))
			return false;
		if (quantity == null)
		{
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderContents [id=" + id + ", orderInfo=" + orderInfo
				+ ", dish=" + dish + ", quantity=" + quantity + "]";
	}
	
	

} 
