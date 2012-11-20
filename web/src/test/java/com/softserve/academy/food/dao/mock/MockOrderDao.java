package com.softserve.academy.food.dao.mock;

import com.softserve.academy.food.dao.OrderDao;
import com.softserve.academy.food.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("MockOrderDao")
public class MockOrderDao implements OrderDao {
    public List<Order> orders = new ArrayList<Order>();

    public Order get(int id) {
        return orders.get(id - 1);
    }

    public List<Order> getAll() {
        return orders;
    }

    public Order add(Order order) {
        orders.add(order);
        order.setId(orders.size());

        return order;

    }

    public List<Order> getAll(String login) {
        List<Order> orders = new ArrayList<Order>();

        for (Order order : this.orders) {
            if (order.getUser().getName().equals(login)) {
                orders.add(order);
            }
        }
        return orders;
    }


}
