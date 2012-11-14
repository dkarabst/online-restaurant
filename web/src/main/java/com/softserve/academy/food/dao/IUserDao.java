package com.softserve.academy.food.dao;

import java.util.List;

import com.softserve.academy.food.entity.User;

public interface IUserDao extends IDao {
	
	public User get(int id);
	public List<User> getAll();
	public User get(String name);
	public User add(User user);
	public void delete(int id);

}
