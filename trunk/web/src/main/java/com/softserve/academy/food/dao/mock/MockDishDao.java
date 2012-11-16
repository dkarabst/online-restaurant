package com.softserve.academy.food.dao.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.softserve.academy.food.dao.IDishDao;
import com.softserve.academy.food.entity.Category;
import com.softserve.academy.food.entity.Dish;

@Repository("MockDishDao")
public class MockDishDao implements IDishDao 
{
	private List<Dish> dishes = new ArrayList<Dish>();

	public Dish get(int id) 
	{
		if ( dishes.isEmpty() || id<1 )
		{
			return null;
		}
		return dishes.get(id-1);
	}

	public Dish add( Dish dish ) 
	{
		dishes.add(dish);
		dish.setId(dishes.size());
		
		return dish;
	}
	
	public void update( Object object ) 
	{
		Dish user = (Dish)object;
		dishes.set( user.getId()-1, user );
	}

	public List<Dish> getAll() 
	{
		return dishes;
	}

	public void delete(int id) 
	{
		dishes.remove(id-1);
	}

	public void delete( Object object ) 
	{
		Dish user = (Dish)object;
		dishes.remove(user.getId()-1);
	}

	public List<Dish> getAll(Category category) 
	{
		List<Dish> dishes = new ArrayList<Dish>();
		
		for (Dish dish : this.dishes)
		{
			if ( dish.getCategory().equals(category) )
			{
				dishes.add(dish);
			}
		}
		return dishes;
	}
}
