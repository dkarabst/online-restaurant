package com.softserve.academy.food.dao.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.softserve.academy.food.dao.ICategoryDao;
import com.softserve.academy.food.entity.Category;

@Repository("MockCategoryDao")
public class MockCategoryDao implements ICategoryDao 
{
	private List<Category> categoryList = new ArrayList<Category>();
	
	public Category add( Category category ) 
	{
		categoryList.add( category );
		category.setId( categoryList.size() );
		
		return category;
	}

	public List<Category> getAll() 
	{
		return categoryList;
	}

	public void delete(int id) 
	{
		if ( categoryList.size()>0 )
		{
			for ( Category category : categoryList)
			{
				if (category.getId()==id)
				{
					categoryList.remove( category );
					break;
				}
			}
		}
	}

	public Category get(int id) 
	{
		if ( categoryList.size()>0 )
		{
			for ( Category category : categoryList)
			{
				if (category.getId()==id)
				{
					return category;
				}
			}
		}

		return null;
	}
	
	
}
