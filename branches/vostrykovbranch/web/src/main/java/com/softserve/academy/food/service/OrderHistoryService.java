package com.softserve.academy.food.service;



import java.util.List;

import com.softserve.academy.food.entity.Order;

public interface OrderHistoryService {

    public Order get(int id);

    public List<Order> getAll();

    public List<Order> getUserHistory();

}
