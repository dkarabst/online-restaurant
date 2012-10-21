package com.softserve.academy.food.xml;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.softserve.academy.food.entity.Category;
import com.softserve.academy.food.model.CategoryModel;

public class CategoryTest
{
	public static void main(String[] args) throws FileNotFoundException,
			ClassNotFoundException
	{
		CategoryXML c = new CategoryXML();
		Category cat= new Category();
		cat.setId(1);
		cat.setName("Vine");
		Category cat2= new Category();
		cat2.setId(2);
		cat2.setName("Vodka");
		//add
		c.addModel(cat);
		c.addModel(cat2);
		c.addModel(cat2);
		ArrayList<CategoryModel> l = c.getAllModels();
		for (CategoryModel m : l)
			System.out.println(m);
		
	}
}
