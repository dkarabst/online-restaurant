package com.softserve.academy.food.xml;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.softserve.academy.food.entity.Category;
import com.softserve.academy.food.model.CategoryModel;

public class CategoryTest {
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException{
						CategoryXML c = new CategoryXML();
						CategorySimple cat = new CategorySimple(1,"Vine");
						c.addModel(cat);
						ArrayList<CategoryModel> l =c.getAllModels();
						for (CategoryModel m : l)
						System.out.println(m);
						
	}
}
