package com.softserve.academy.food.dao.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.softserve.academy.food.dao.IUserDao;
import com.softserve.academy.food.entity.User;

@Repository("MockuserDao")
public class MockUserDao implements IUserDao {
	
	private List<User> users = new ArrayList<User>();

	public User get(int id) {
	
		return users.get(id-1);
	}

	public User get(String name) {
		
		for (User user : users)
		{
			if ( user.getName().equals(name) )
			{
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
	
	public void update(User user) {

		users.set(user.getId()-1, user);
	}

	public List<User> getAll() {
		
		return users;
	}

	public void delelete(int id) {
		
		users.remove(id-1);
	}

	public void delelete(User user) {
		
		users.remove(user.getId()-1);
	}

}
