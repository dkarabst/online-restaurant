package com.softserve.academy.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.softserve.academy.food.dao.IUserDao;
import com.softserve.academy.food.dao.mock.MockUserDao;
import com.softserve.academy.food.entity.User;
import com.softserve.academy.food.model.UserCredentials;
import com.softserve.academy.food.model.UserModel;
import com.softserve.academy.food.service.IUserService;
import com.softserve.academy.food.service.impl.UserService;


public class UserServiceTest {
	
	private IUserService uService = new UserService();
	private IUserDao userDao;

	@Before
	public void setUp() throws Exception 
	{
		userDao = new MockUserDao();
		uService.setUserDao(userDao);
	}

	@Test
	public void testCheckUserEmptyBD() 
	{
		assertFalse( uService.checkUser("Vasa") );
	}
	
	@Test
	public void testCheckUser() 
	{
		userDao.add( new  User("Vasa", "1234") );
		
		assertFalse( uService.checkUser("Peta") );
		assertTrue( uService.checkUser("Vasa") );
	}

	@Test
	public void testAddUserEmptyBD() 
	{
		UserCredentials user = new UserCredentials("Vasa", "1234");
		
		assertTrue( uService.addUser(user) );
		assertFalse( userDao.getAll().isEmpty() );
		assertEquals( userDao.getAll().size(), 1 );
		assertEquals( userDao.get(1).getName(), user.getName() );
	}
	
	@Test
	public void testAddUser() 
	{
		userDao.add( new  User("Vasa", "1234") );
		UserCredentials user = new UserCredentials("Peta", "1234");
		
		assertTrue( uService.addUser(user) );
		assertFalse(userDao.getAll().isEmpty());
		assertEquals( userDao.getAll().size(), 2 );
		assertEquals( userDao.get(2).getName(), user.getName() );
	}

	@Test
	public void testGetUser() 
	{
		userDao.add( new  User("Vasa", "1234") );
		assertEquals( userDao.get(1).getName(), "Vasa" );
	}

	@Test
	public void testUpdate() 
	{
		User user = new User("Vasa", "1234");
		user = userDao.add( user );
		
		UserModel change = new UserModel( user );
		change.setPhone("3434995");
		
		uService.update( change );
		assertEquals( userDao.get(1).getPhone(), "3434995" );
	}

}
