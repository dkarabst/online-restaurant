package com.softserve.academy.food.xml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.softserve.academy.food.entity.Category;
import com.softserve.academy.food.model.CategoryModel;
import com.softserve.academy.food.model.IModel;

public class CategoryXML
{
	
	public XMLEncoder GetXMLEncoder() throws FileNotFoundException{
		return  new XMLEncoder(new FileOutputStream(new File(
				"D:\\Category.xml")));
	}
	
	public XMLDecoder GetXMLDecoder() throws FileNotFoundException{
		return new XMLDecoder(new FileInputStream(new File(
				"D:\\Category.xml")));
	}

	
	public void addModel(ArrayList<Category> cat) throws ClassNotFoundException,
			FileNotFoundException
	{   
		XMLEncoder e = GetXMLEncoder();
		e.writeObject(cat);
		e.close();  
	}


	public ArrayList<CategoryModel> getAllModels() throws FileNotFoundException
	{
		XMLDecoder d = GetXMLDecoder();
		ArrayList<Category> cat = new ArrayList<Category>();
		cat=(ArrayList<Category>) d.readObject();
		CategoryModel model = null;
		ArrayList<CategoryModel> modelList = new ArrayList<CategoryModel>();
		for (Category entity : cat)
		{
			model = new CategoryModel(entity.getId(), entity.getName());
			modelList.add(model);
		}
		d.close();
		return modelList;
	}

	public void delModelById(int id) throws FileNotFoundException
	{   	
		XMLDecoder d = GetXMLDecoder();
		ArrayList<Category> cat = new ArrayList<Category>();
		cat=(ArrayList<Category>) d.readObject();
		for (int i = 0; i < cat.size(); i++)
		{
			Category c = cat.get(i);
			if (c.getId().equals(id))
			{
				cat.remove(i);
			}
		
		}
		XMLEncoder e = GetXMLEncoder();
		e.writeObject(cat);
		e.close();
	}

	public void delModelByName(String name) throws FileNotFoundException
	{
		XMLDecoder d = GetXMLDecoder();
		ArrayList<Category> cat = new ArrayList<Category>();
		cat=(ArrayList<Category>) d.readObject();

		for (Category c : cat)
		{
			if (c.getName().equals(name))
			{
				cat.remove(c);
			}
		
		}
		XMLEncoder e = GetXMLEncoder();
		e.writeObject(cat);
		e.close();
	}

	public CategoryModel getModelById(int id) throws FileNotFoundException
	{
		XMLDecoder d = GetXMLDecoder();
		CategoryModel catmodel = null;
		ArrayList<Category> cat = new ArrayList<Category>();
		cat=(ArrayList<Category>) d.readObject();

		for (int i = 0; i < cat.size(); i++)
		{
			Category c = (Category) cat.get(i);
			if (c.getId().equals(id))
			{
				catmodel = new CategoryModel(c.getId(), c.getName());
			}
		}
		d.close();
		return catmodel;
	}

	public IModel getModelByName(String name) throws FileNotFoundException
	{
		XMLDecoder d = GetXMLDecoder();
		CategoryModel catmodel = null;
		ArrayList<Category> cat = new ArrayList<Category>();
		cat=(ArrayList<Category>) d.readObject();
		for (int i = 0; i < cat.size(); i++)
		{
			Category c = cat.get(i);
			if (c.getName().equals(name))
			{
				catmodel = new CategoryModel(c.getId(), c.getName());
			}
		}
		d.close();
		return catmodel;
	}

}
