package com.softserve.academy.food.dao.impl;

import com.softserve.academy.food.dao.IDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class Dao implements IDao {

    @Autowired
    protected SessionFactory sessionFactory;

    Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void update(Object object) {
        getSession().update(object);
    }

    public void delete(Object object) {
        getSession().delete(object);
    }


}
