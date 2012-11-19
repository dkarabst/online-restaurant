package com.softserve.academy.food.dao.mock;

import com.softserve.academy.food.dao.UserDao;
import com.softserve.academy.food.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("MockUserDao")
public class MockUserDao implements UserDao {

    private List<User> users = new ArrayList<User>();

    public User get(int id) {

        if (users.isEmpty() || id < 1) {
            return null;
        }

        return users.get(id - 1);
    }

    public User get(String name) {

        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }

        return null;
    }

    public User add(User user) {

        users.add(user);
        user.setId(users.size());

        return user;
    }

    public void update(Object object) {

        User user = (User) object;
        users.set(user.getId() - 1, user);
    }

    public List<User> getAll() {

        return users;
    }

    public void delete(int id) {

        users.remove(id - 1);
    }

    public void delete(Object object) {
        User user = (User) object;
        users.remove(user.getId() - 1);
    }


}
