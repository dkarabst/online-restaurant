package com.softserve.academy.food.dao;

import com.softserve.academy.food.dao.UserDao;
import com.softserve.academy.food.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends DaoImpl implements UserDao {
    public User get(int id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        return (List<User>) sessionFactory.getCurrentSession().createQuery("from User ").list();
    }

    @SuppressWarnings("unchecked")
    public User get(String name) {
        List<User> list = sessionFactory.getCurrentSession().createQuery("from User where USER_NAME = '" + name + "'").list();

        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public User add(User user) {
        user.setId((Integer) sessionFactory.getCurrentSession().save(user));

        return user;
    }

    public void delete(int id) {
        User object = (User) sessionFactory.getCurrentSession().load(
                User.class, id);
        if (null != object) {
            sessionFactory.getCurrentSession().delete(object);
        }
    }

}
