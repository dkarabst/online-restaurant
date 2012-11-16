package com.softserve.academy.food.service.impl;

import com.softserve.academy.food.dao.IDishDao;
import com.softserve.academy.food.dao.IOrderDao;
import com.softserve.academy.food.dao.IUserDao;
import com.softserve.academy.food.entity.Dish;
import com.softserve.academy.food.entity.OrderContents;
import com.softserve.academy.food.entity.OrderInfo;
import com.softserve.academy.food.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("orderService")
public class OrderService implements IOrderService {
    @Autowired
    private IOrderDao orderDao;

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IDishDao dishDao;

    @Transactional
    public void add(Map<Integer, Integer> dishIdsToQuantities) {
        OrderInfo order = new OrderInfo();
        order.setUser(userDao.get(getLogin()));
        order.setDate(new Date());

        List<OrderContents> ordercontents = new ArrayList<OrderContents>();

        for (Map.Entry<Integer, Integer> item : dishIdsToQuantities.entrySet()) {
            Dish dish = dishDao.get(item.getKey());
            ordercontents.add(new OrderContents(dish, item.getValue(), order));
        }

        order.setSpec(ordercontents);

        orderDao.add(order);
    }

    private String getLogin() {
        String login = "guest";

        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            if (principal instanceof UserDetails) {
                login = ((UserDetails) principal).getUsername();
            } else {
                login = principal.toString();
            }
        } catch (NullPointerException e) {

        }
        return login;
    }

}
