package com.softserve.academy.food.service;


import com.softserve.academy.food.dao.OrderDAO;
import com.softserve.academy.food.model.IModel;
import com.softserve.academy.food.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class OrderHistoryServiceImpl implements OrderHistoryService{

    @Autowired
    private OrderDAO orderDAO;

    @Transactional
    public IModel getModelById(Integer id) {
        return  orderDAO.getModelById(id);
    }

    @Transactional
    public List<OrderModel> getAllModels() {
        return orderDAO.getAllModels();
    }

    @Transactional

    public void delModelById(Integer id) {
        orderDAO.delModelById(id);
    }
}
