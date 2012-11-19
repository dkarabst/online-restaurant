package com.softserve.academy.food.dao.mock;

import com.softserve.academy.food.dao.IOrderDao;
import com.softserve.academy.food.entity.OrderInfo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("MockOrderDao")
public class MockOrderDao implements IOrderDao {
    public List<OrderInfo> orders = new ArrayList<OrderInfo>();

    public OrderInfo get(int id) {
        return orders.get(id - 1);
    }

    public List<OrderInfo> getAll() {
        return orders;
    }

    public OrderInfo add(OrderInfo order) {
        orders.add(order);
        order.setId(orders.size());

        return order;

    }

    public List<OrderInfo> getAll(String login) {
        List<OrderInfo> orders = new ArrayList<OrderInfo>();

        for (OrderInfo order : this.orders) {
            if (order.getUser().getName().equals(login)) {
                orders.add(order);
            }
        }
        return orders;
    }


}
