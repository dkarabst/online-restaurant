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
		ArrayList<Category> m = new ArrayList<Category>();
		Category cat = new Category();
		cat.setId(1);
		cat.setName("Vine");
		Category cat2 = new Category();
		cat2.setId(2);
		cat2.setName("Vodka");
		Category cat3 = new Category();
		cat3.setId(3);
		cat3.setName("Pivo");
		m.add(cat);
		m.add(cat2);
		m.add(cat3);
		
		c.addModel(m);
		
		
		ArrayList<CategoryModel> l = c.getAllModels();
		for (CategoryModel mm : l)
			System.out.println(mm);
		
        c.delModelById(2);
        
        ArrayList<CategoryModel> ll = c.getAllModels();
		for (CategoryModel mm : ll)
			System.out.println(mm);
        
        CategoryModel lm = c.getModelById(3);
		//for (CategoryModel mm : lm)
			System.out.println("cat is"+lm);
			
	        CategoryModel lmm = (CategoryModel) c.getModelByName("Vine");
			//for (CategoryModel mm : lm)
				System.out.println("cat is"+lmm);
		
		c.delModelByName("Vine");
		
	     ArrayList<CategoryModel> lll = c.getAllModels();
			for (CategoryModel mm : lll)
				System.out.println("Itog"+mm);
		
	}
}
