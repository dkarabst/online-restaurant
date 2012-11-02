package com.softserve.academy.food.model;

public class ContentModel
{
	private int			id;
	private int			orderInfo_id;
	private DishModel	dish;
	private Integer		quantity;

	public ContentModel()
	{
	}

	@Override
	public String toString()
	{
		return "Model - " + id + " order - " + orderInfo_id + " Dish - " + dish
				+ " quantity - " + quantity;
	}

	public ContentModel(int id, int orderInfo_id, DishModel dish,
			Integer quantity)
	{
		this.id = id;
		this.orderInfo_id = orderInfo_id;
		this.dish = dish;
		this.quantity = quantity;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getOrderInfo_id()
	{
		return orderInfo_id;
	}

	public void setOrderInfo_id(int orderInfo_id)
	{
		this.orderInfo_id = orderInfo_id;
	}

	public DishModel getDish()
	{
		return dish;
	}

	public void setDish(DishModel dish)
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

}
