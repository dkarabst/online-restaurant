package com.softserve.academy.food.service;



import java.util.List;

import com.softserve.academy.food.entity.OrderInfo;

public interface OrderHistoryService {

    public OrderInfo get(int id);

    public List<OrderInfo> getAll();

    public List<OrderInfo> getUserHistory();

}
