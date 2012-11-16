package com.softserve.academy.food.service;

import com.softserve.academy.food.model.OrderModel;

import java.util.List;

public interface IOrderHistoryService {

    public OrderModel get(int id);

    public List<OrderModel> getAll();

    public List<OrderModel> getUserHistory();

}
