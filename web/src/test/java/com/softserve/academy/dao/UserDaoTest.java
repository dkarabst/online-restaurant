package com.softserve.academy.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.academy.food.dao.IUserDao;
import com.softserve.academy.food.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"resources/beans.xml"})
public class UserDaoTest 
{
	@Autowired
	private IUserDao userDao;
	@Autowired
	protected SessionFactory session;

	@After
	@Transactional
	public void tearDown() throws Exception 
	{
		 session.getCurrentSession().createQuery("delete from User").executeUpdate();;
	}

	@Test
	@Transactional
	public void testGetIntEmpty() 
	{
		assertEquals( userDao.get(1), null );
	}
	
	@Test
	@Transactional
	public void testGetInt() 
	{
		User user =  new  User("Vasa", "1234");
		user = userDao.add( user );
		
		assertEquals( userDao.get(user.getId()), user );
	}
	
	@Test
	@Transactional
	public void testGetIntMany() 
	{
		userDao.add( new  User("Peta", "1234") );
		userDao.add( new  User("Kosta", "1234") );
		User user = userDao.add( new  User("Vasa", "1234") );
		userDao.add( new  User("Alex", "1234") );
		
		assertEquals( userDao.get(user.getId()), user );
	}

	@Test
	@Transactional
	public void testGetStringEmpty() 
	{
		assertEquals( userDao.get("Vasa"), null );
	}
	
	@Test
	@Transactional
	public void testGetString() 
	{
		userDao.add( new  User("Peta", "1234") );
		userDao.add( new  User("Kosta", "1234") );
		User user = userDao.add( new  User("Vasa", "1234") );
		userDao.add( new  User("Alex", "1234") );
		
		assertEquals( userDao.get("Vasa"), user );
	}
	
	@Test
	@Transactional
	public void testGetAllEmpty() 
	{
		assertTrue( userDao.getAll().isEmpty() );
	}
	
	@Test
	@Transactional
	public void testGetAll() 
	{
		ArrayList<User> userList = new ArrayList<User>();
		
		userList.add( userDao.add(new  User("Peta", "1234")) );
		userList.add( userDao.add(new  User("Kosta", "1234")) );
		userList.add( userDao.add(new  User("Alex", "1234")) );
		
		assertFalse( userDao.getAll().isEmpty() );
		assertEquals( userDao.getAll(), userList );
	}

	@Test
	@Transactional
	public void testAddEmpty() 
	{
		User user = userDao.add( new  User("Vasa", "1234") );
		
		assertFalse( userDao.getAll().isEmpty() );
		assertEquals( userDao.get(user.getId()), user );
		assertEquals( userDao.get("Vasa"), user );
	}
	
	@Test
	@Transactional
	public void testAdd() 
	{
		userDao.add( new  User("Peta", "1234") );
		userDao.add( new  User("Kosta", "1234") );
		
		User user = userDao.add( new  User("Vasa", "1234") );
		
		assertFalse( userDao.getAll().isEmpty() );
		assertEquals( userDao.get(user.getId()), user );
		assertEquals( userDao.get("Vasa"), user );
	}

	@Test
	@Transactional
	public void testDeleteInt() 
	{
		userDao.add( new  User("Peta", "1234") );
		
		userDao.delete(1);
		
		assertTrue( userDao.getAll().isEmpty() );
	}
	
	@Test
	@Transactional
	public void testDeleteIntMany() 
	{
		userDao.add( new  User("Peta", "1234") );
		User user = userDao.add( new  User("Vasa", "1234") );
		userDao.add( new  User("Peta", "1234") );
		
		userDao.delete(user.getId());
		
		assertFalse( userDao.getAll().isEmpty() );
		assertEquals( userDao.get(user.getId()), user );
		assertEquals( userDao.get("Vasa"), user );
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteObject() {
		fail("Not yet implemented");
	}

}
