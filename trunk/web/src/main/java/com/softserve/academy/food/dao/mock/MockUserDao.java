package com.softserve.academy.food.dao.mock;

import java.util.ArrayList;
import java.util.List;

import com.softserve.academy.food.dao.IUserDao;
import com.softserve.academy.food.entity.User;

public class MockUserDao implements IUserDao {
	
	private List<User> listUser = new ArrayList<User>();

	public User get(int id) {
	
		return listUser.get(id-1);
	}

	public User get(String name) {
		
		for (User user : listUser)
		{
			if ( user.getName().equals(name) )
			{
				return user;
			}
		}
		
		return null;
	}

	public User add(User user) {
		
		listUser.add(user);
		user.setId(listUser.size());
		
		return user;
	}
	
	public void update(User user) {

		listUser.set(user.getId(), user);
	}

	public List<User> getAll() {
		
		return listUser;
	}

	public void delelete(int id) {
		
		listUser.remove(id-1);
	}

	public void delelete(User user) {
		
		listUser.remove(user.getId()-1);
	}

}
