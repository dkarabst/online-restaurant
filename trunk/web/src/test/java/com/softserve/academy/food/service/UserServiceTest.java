package com.softserve.academy.food.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.softserve.academy.food.dao.IUserDao;
import com.softserve.academy.food.entity.User;
import com.softserve.academy.food.model.UserCredentials;
import com.softserve.academy.food.model.UserModel;
import com.softserve.academy.food.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/service/beans.xml"})
public class UserServiceTest 
{
	@Autowired
	private IUserService uService;
	@Autowired
	private IUserDao userDao;

	@Before
	public void setUp() throws Exception
	{
		userDao.getAll().clear();
	}

	@Test
	public void testCheckUserEmptyBD() 
	{
		assertFalse( uService.isRegistered("Vasa") );
	}
	
	@Test
	public void testCheckUser() 
	{
		userDao.add( new  User("Vasa", "1234") );
		
		assertFalse( uService.isRegistered("Peta") );
		assertTrue( uService.isRegistered("Vasa") );
	}

	@Test
	public void testAddUserEmptyBD() 
	{
		UserCredentials user = new UserCredentials("Vasa", "1234");
		
		assertTrue( uService.add(user) );
		assertFalse( userDao.getAll().isEmpty() );
		assertEquals( userDao.getAll().size(), 1 );
		assertEquals( userDao.get(1).getName(), user.getName() );
	}
	
	@Test
	public void testAddUser() 
	{
		userDao.add( new  User("Vasa", "1234") );
		UserCredentials user = new UserCredentials("Peta", "1234");
		
		assertTrue( uService.add(user) );
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
