package com.softserve.academy.food.service.impl;

import com.softserve.academy.food.dao.IUserDao;
import com.softserve.academy.food.entity.User;
import com.softserve.academy.food.model.UserCredentials;
import com.softserve.academy.food.model.UserModel;
import com.softserve.academy.food.security.Coding;
import com.softserve.academy.food.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    public UserModel getUser(String name) {
        return userDao.get(name).toModel();
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
    
    @Transactional
    public User getUser() {
        return userDao.get( getLogin() );
    }
    
    private String getLogin() {
        String login = "guest";

        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            if (principal instanceof UserDetails) {
                login = ((UserDetails) principal).getUsername();
            } else {
                login = principal.toString();
            }
        } catch (NullPointerException e) {

        }
        return login;
    }

}
