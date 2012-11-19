package com.softserve.academy.food.dao;

import com.softserve.academy.food.dao.DishAttachmentDao;
import com.softserve.academy.food.entity.DishAttachment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DishAttachmentDaoImpl implements DishAttachmentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add( DishAttachment attachment ) {
        getSession().save(attachment);
    }

    @Override
    public DishAttachment get(Long id) {
        return (DishAttachment) getSession().load(DishAttachment.class, id);
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<DishAttachment> getAll() {
        return getSession().createQuery("from DishAttachment").list();
    }

}
