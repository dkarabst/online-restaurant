package com.softserve.academy.food.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.softserve.academy.food.dao.ICategoryDao;
import com.softserve.academy.food.entity.Category;
import com.softserve.academy.food.model.CategoryModel;
import com.softserve.academy.food.service.ICategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"beans.xml"})
public class CategoryServiceTest 
{
	@Autowired
	private ICategoryService cService;
	@Autowired
	private ICategoryDao categoryDao;
	
	@Before
	public void setUp() throws Exception 
	{
		categoryDao.getAll().clear();
	}
	
	@Test
	public void testGetAllEmpty() 
	{
		assertTrue( cService.getAll().isEmpty() );
	}

	@Test
	public void testGetAll() 
	{
		categoryDao.add( new Category("Dessert") );
		
		assertFalse( cService.getAll().isEmpty() );
		assertEquals( cService.getAll().get(0).getName(), "Dessert" );
	}

	@Test
	public void testGetEmpty() 
	{
		assertEquals( cService.get(1), new CategoryModel() );
	}
	
	@Test
	public void testGet() 
	{
		categoryDao.add( new Category("Dessert") );
		
		assertEquals( cService.get(1).getName(), "Dessert" );
	}

	@Test
	public void testAddEmpty() 
	{
		cService.add( new CategoryModel("Dessert") );
		
		assertFalse( categoryDao.getAll().isEmpty() );
		assertEquals( categoryDao.get(1).getName(), "Dessert" );
	}

	@Test
	public void testAdd() 
	{
		categoryDao.add( new Category("Dessert") );
		
		cService.add( new CategoryModel("Fist dish") );
		
		assertEquals( categoryDao.get(2).getName(), "Fist dish" );
	}
	
	@Test
	public void testDeleteEmpty() 
	{
		categoryDao.delete(1);
	}
	
	@Test
	public void testDeleteOne() 
	{
		categoryDao.add( new Category("Dessert") );
		
		categoryDao.delete(1);
		
		assertTrue( categoryDao.getAll().isEmpty() );
	}
	
	@Test
	public void testDelete() 
	{
		categoryDao.add( new Category("Dessert") );
		categoryDao.add( new Category("Fist dish") );
		
		categoryDao.delete(1);
		
		assertFalse( categoryDao.getAll().isEmpty() );
		assertEquals( categoryDao.get(2).getName(), "Fist dish" );
	}

}
