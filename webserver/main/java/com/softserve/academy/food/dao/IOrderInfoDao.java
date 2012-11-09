package com.softserve.academy.food.dao;

import java.util.ArrayList;
import com.softserve.academy.food.entity.OrderInfo;


public interface IOrderInfoDao {
	
	public OrderInfo get(Integer id);
	public ArrayList<OrderInfo> getAll();
	public void add( OrderInfo order );
	public ArrayList<OrderInfo> getAll( String login );

}
