package com.softserve.academy.food.service;

import com.softserve.academy.food.dao.OrderDao;
import com.softserve.academy.food.entity.OrderInfo;
import com.softserve.academy.food.model.OrderModel;
import com.softserve.academy.food.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("orderHistoryService")
public class OrderHistoryServiceImpl implements OrderHistoryService {
    @Autowired
    private OrderDao orderDao;

    @Transactional
    public List<OrderModel> get(String login) {
        ArrayList<OrderModel> models = new ArrayList<OrderModel>();
        for (OrderInfo m : orderDao.getAll(login)) {
            models.add(m.toModel());
        }
        return models;
    }

    @Transactional
    public OrderModel get(int id) {
        return orderDao.get(id).toModel();
    }

    @Override
    //spring security annotation for admin role
    public List<OrderModel> getAll() {
        //admin service
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<OrderModel> getUserHistory() {
        //Get user id and history for this id
        return null;
    }


}
