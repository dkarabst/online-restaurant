package com.softserve.academy.food.dao.impl;

import com.softserve.academy.food.dao.IUserDao;
import com.softserve.academy.food.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDao extends Dao implements IUserDao {
    public User get(int id) {
        return (User) getSession().get(User.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        return (List<User>) getSession().createQuery("from User ").list();
    }

    @SuppressWarnings("unchecked")
    public User get(String name) {
        List<User> list = getSession().createQuery("from User where USER_NAME = '" + name + "'").list();

        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public User add(User user) {
        user.setId((Integer) getSession().save(user));

        return user;
    }

    public void delete(int id) {
        User object = (User) getSession().load(
                User.class, id);
        if (null != object) {
            getSession().delete(object);
        }
    }

}
