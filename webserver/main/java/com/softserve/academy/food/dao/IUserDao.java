package com.softserve.academy.food.dao;

import java.util.List;

import com.softserve.academy.food.entity.User;

public interface IUserDao {
	
	public User get(int id);
	public List<User> getAll();
	public User get(String name);
	public User add(User user);
	public void delelete(int id);
	public void delelete(User user);
	public void update(User user);

}
