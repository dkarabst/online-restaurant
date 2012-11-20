package com.softserve.academy.food.dao;

import com.softserve.academy.food.entity.Order;

import java.util.List;

public interface OrderDao {
    public Order get(int id);

    public List<Order> getAll();

    public Order add(Order order);

    public List<Order> getAll(String login);

}
