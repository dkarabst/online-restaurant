package com.softserve.academy.food.service;


import com.softserve.academy.food.model.IModel;
import com.softserve.academy.food.model.OrderModel;

import java.util.List;

public interface OrderHistoryService {

    public IModel getModelById(Integer id);
    public List<OrderModel> getAllModels();
    public void delModelById(Integer id);
}
