package com.softserve.academy.food.dao;

import com.softserve.academy.food.dao.UserAttachmentDao;
import com.softserve.academy.food.entity.UserAttachment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserAttachmentDaoImpl implements UserAttachmentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(UserAttachment userAttachment) {
        getSession().save(userAttachment);
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<UserAttachment> getAll() {
        return getSession().createQuery("from UserAttachment").list();
    }
}
