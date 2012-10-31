package com.softserve.academy.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.academy.food.dao.UserDAO;
import com.softserve.academy.food.entity.User;
import com.softserve.academy.food.model.UserCredentials;
import com.softserve.academy.food.model.UserModel;
import com.softserve.academy.food.security.Coding;

@Service("userService")
public class UserService implements IUserService
{

	@Autowired
	private UserDAO	daoUser;

	@Transactional
	public boolean checkUser(String name)
	{
		if (daoUser.get(name) == null)
		{
			return false;
		}

		return true;
	}

	@Transactional
	public void addUser(UserCredentials user)
	{

		if (user != null)
		{
			Coding code = new Coding();
			user.setPassword(code.getHash(user.getPassword()));

			daoUser.add(new User(user));
		}
	}

	@Transactional
	public UserModel getUser(int id)
	{
		return daoUser.get(id).toModel();
	}

	@Transactional
	public void update(UserModel user)
	{
		if (user != null)
		{
			User oldUser = daoUser.get(user.getId());

			oldUser.setPhone(user.getPhone());
			oldUser.setEmail(user.getEmail());

			daoUser.update(oldUser);
		}
	}

}
