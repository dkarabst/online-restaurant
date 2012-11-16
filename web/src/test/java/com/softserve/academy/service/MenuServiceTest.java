package com.softserve.academy.service;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.softserve.academy.food.dao.IDishDao;
import com.softserve.academy.food.entity.Category;
import com.softserve.academy.food.entity.Dish;
import com.softserve.academy.food.model.CategoryModel;
import com.softserve.academy.food.model.DishModel;
import com.softserve.academy.food.service.IMenuService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"beans.xml"})
public class MenuServiceTest 
{
	@Autowired
	private IMenuService mService;
	@Autowired
	private IDishDao dishDao;

	@Before
	public void setUp() throws Exception 
	{
		dishDao.getAll().clear();
	}

	@Test
	public void getAllEmpty()
	{
		assertTrue( mService.getAll().isEmpty() );
	}
	
	@Test
	public void getAll()
	{
		Dish dish = new Dish( "IceCream", new Category("Dessert") );
		dishDao.add( dish );
		
		assertFalse( mService.getAll().isEmpty() );
		assertEquals(mService.getAll().get(0).getName(), dishDao.getAll().get(0).getName());
	}
	
	@Test
	public void getAllCategoryEmpty()
	{
		CategoryModel category = new CategoryModel("Dessert");
		
		assertTrue( mService.getAll(category).isEmpty() );
	}
	
	@Test
	public void getAllCategory()
	{
		CategoryModel category = new CategoryModel("Dessert");
		Dish dish = new Dish( "IceCream", new Category("Dessert") );
		dishDao.add( dish );
		
		assertFalse( mService.getAll(category).isEmpty() );
		assertEquals(mService.getAll(category).get(0).getCategory().getName(), "Dessert");
	}
	
	@Test
	public void getAllCategoryMany()
	{
		CategoryModel category = new CategoryModel("Dessert");
		
		dishDao.add( new Dish( "IceCream", new Category("Dessert") ) );
		dishDao.add( new Dish( "Gilet", new Category("Dessert") ) );
		dishDao.add( new Dish( "IceCream", new Category("Dessert") ) );
		dishDao.add( new Dish( "Gilet", new Category("Dessert") ) );
		dishDao.add( new Dish( "Soup", new Category("Fist") ) );
		dishDao.add( new Dish( "Soup", new Category("Fist") ) );
		
		assertFalse( mService.getAll(category).isEmpty() );
		
		for ( DishModel dish : mService.getAll(category) )
		{
			assertEquals(dish.getCategory().getName(), "Dessert");
		}
	}
	
	@Test
	public void getEmpty()
	{
		assertTrue( mService.get(1).equals(new DishModel()) );
	}
	
	
	@Test
	public void get()
	{
		Dish dish = new Dish( "IceCream", new Category("Dessert") );
		dishDao.add( dish );
		
		assertEquals( mService.get(1).getName(), "IceCream");
	}

}
