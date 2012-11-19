package com.softserve.academy.food.dao.impl;

import com.softserve.academy.food.dao.IOrderDao;
import com.softserve.academy.food.entity.OrderInfo;
import com.softserve.academy.food.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("orderDao")
public class OrderDao implements IOrderDao {
    @Autowired
    private SessionFactory sessionFactory;

    public OrderInfo get(int id) {
        return (OrderInfo) sessionFactory.getCurrentSession().get(
                OrderInfo.class, id);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<OrderInfo> getAll() {
        return (ArrayList<OrderInfo>) sessionFactory.getCurrentSession()
                .createQuery("from OrderInfo").list();
    }

    @SuppressWarnings("unchecked")
    public ArrayList<OrderInfo> getAll(String login) {
        User user = (User) sessionFactory.getCurrentSession().createQuery("from User where name ='" + login + "'").list().get(0);

        return (ArrayList<OrderInfo>) sessionFactory.getCurrentSession()
                .createQuery("from OrderInfo where USERS_user_id=" + user.getId()).list();
    }

    public OrderInfo add(OrderInfo order) {
        order.setId((Integer) sessionFactory.getCurrentSession().save(order));

        return order;
    }

}
