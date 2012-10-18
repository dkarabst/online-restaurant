package com.softserve.academy.food.model;
//package com.hello.model;

import com.softserve.academy.food.entity.Dish;
import com.softserve.academy.food.entity.OrderInfo;

public class OrderSpecModel implements IModel
{
	private OrderInfo orderInfo;
	private Dish dish;
	private Integer quantity;
	
	public OrderSpecModel()
	{
	}

	public OrderSpecModel(OrderInfo orderInfo, Dish dish, Integer quantity)
	{
		this.orderInfo = orderInfo;
		this.dish = dish;
		this.quantity = quantity;
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
	
	
	
	

}
