package com.softserve.academy.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.academy.food.dao.UserDao;
import com.softserve.academy.food.entity.User;
import com.softserve.academy.food.model.UserCredentials;
import com.softserve.academy.food.model.UserModel;
import com.softserve.academy.food.security.Coding;

@Service
public class userService implements iUserService {
	
	@Autowired
	private UserDao daoUser;
	
	@Override
	@Transactional
	public boolean checkUser( String name ) {
		if (daoUser.get(name)==null)
		{
			return false;
		} 
		
		return true;
	}
	
	@Override
	@Transactional
	public void addUser(UserCredentials user) {
		
		if (user!=null)
		{
			Coding code = new Coding();
			user.setPassword( code.getHash(user.getPassword()) );
			
			daoUser.add( new User( user ) );
		}
	}
	
	@Override
	@Transactional
	public UserModel getUser(int id) {
		
		UserModel user = new UserModel(daoUser.get(id));
		return user;
	}
	
	@Override
	@Transactional
	public void update( UserModel user )
	{
		if (user!=null)
		{
			User oldUser = daoUser.get(user.getId());
			
			oldUser.setPhone( user.getPhone() );
			oldUser.setEmail( user.getEmail() );

			daoUser.update( oldUser );
		}
	}
	
	
}
