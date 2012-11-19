package com.softserve.academy.food.service.impl;

import com.softserve.academy.food.dao.IUserDao;
import com.softserve.academy.food.entity.User;
import com.softserve.academy.food.model.UserCredentials;
import com.softserve.academy.food.model.UserModel;
import com.softserve.academy.food.security.Coding;
import com.softserve.academy.food.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserService implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Transactional
    public boolean isRegistered(String name) {
        if (userDao.get(name) == null) {
            return false;
        }

        return true;
    }

    @Transactional
    public Boolean add(UserCredentials user) {
        if (user != null) {
            Coding code = new Coding();
            user.setPassword(code.getHash(user.getPassword()));

            if (userDao.add(new User(user)).getId() != 0) {
                return true;
            }
        }
        return false;
    }

    @Transactional
    public UserModel getUser(int id) {
        return userDao.get(id).toModel();
    }

    @Transactional
    public User getUser(String name) {
        return userDao.get(name);
    }

    @Transactional
    public void update(UserModel user) {
        if (user != null) {
            User oldUser = userDao.get(user.getId());

            oldUser.setPhone(user.getPhone());
            oldUser.setEmail(user.getEmail());

            userDao.update(oldUser);
        }
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

}
