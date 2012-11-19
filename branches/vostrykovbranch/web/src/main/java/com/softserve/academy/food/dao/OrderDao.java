package com.softserve.academy.food.dao;

import com.softserve.academy.food.entity.OrderInfo;

import java.util.List;

public interface OrderDao {
    public OrderInfo get(int id);

    public List<OrderInfo> getAll();

    public OrderInfo add(OrderInfo order);

    public List<OrderInfo> getAll(String login);

}
