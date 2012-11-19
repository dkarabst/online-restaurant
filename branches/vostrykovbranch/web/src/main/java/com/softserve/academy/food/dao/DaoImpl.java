package com.softserve.academy.food.dao;

import com.softserve.academy.food.dao.Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DaoImpl implements Dao {

    @Autowired
    protected SessionFactory sessionFactory;

    Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void update(Object object) {
        sessionFactory.getCurrentSession().update(object);
    }

    public void delete(Object object) {
        sessionFactory.getCurrentSession().delete(object);
    }


}
