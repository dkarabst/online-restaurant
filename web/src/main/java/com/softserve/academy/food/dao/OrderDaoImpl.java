package com.softserve.academy.food.dao;

import com.softserve.academy.food.dao.OrderDao;
import com.softserve.academy.food.entity.Order;
import com.softserve.academy.food.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Order get(int id) {
        return (Order) sessionFactory.getCurrentSession().get(
                Order.class, id);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Order> getAll() {
        return (ArrayList<Order>) sessionFactory.getCurrentSession()
                .createQuery("from OrderInfo").list();
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Order> getAll(String login) {
        User user = (User) sessionFactory.getCurrentSession().createQuery("from User where name ='" + login + "'").list().get(0);

        return (ArrayList<Order>) sessionFactory.getCurrentSession()
                .createQuery("from OrderInfo where USERS_user_id=" + user.getId()).list();
    }

    public Order add(Order order) {
        order.setId((Integer) sessionFactory.getCurrentSession().save(order));

        return order;
    }

}
