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
	private XMLEncoder	e;
	private XMLDecoder	d;

	public CategoryXML()
	{
		try
		{
			e = new XMLEncoder(new FileOutputStream(new File(
					"\\java\\CategorySimple.xml")));
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			d = new XMLDecoder(new FileInputStream(new File(
					"\\java\\CategorySimple.xml")));
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addModel(Category cat) throws ClassNotFoundException,
			FileNotFoundException
	{
		e.writeObject(cat);
		e.close();
	}

	public ArrayList<CategoryModel> getAllModels() throws FileNotFoundException
	{
		ArrayList<Category> cat = new ArrayList<Category>();
		cat.add((Category) d.readObject());
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

	public void delModelById(int id)
	{
		ArrayList<Category> cat = new ArrayList<Category>();
		cat.add((Category) d.readObject());
		for (int i = 0; i < cat.size(); i++)
		{
			Category c = cat.get(i);
			if (c.getId().equals(id))
			{
				cat.remove(i);
				e.writeObject(cat);
				e.close();
			}
		}
	}

	public void delModelByName(String name)
	{
		ArrayList<Category> cat = new ArrayList<Category>();
		cat.add((Category) d.readObject());

		for (int i = 0; i < cat.size(); i++)
		{
			Category c = cat.get(i);
			if (c.getName().equals(name))
			{
				cat.remove(i);
				e.writeObject(cat);
				e.close();
			}
		}
	}

	public CategoryModel getModelById(int id)
	{
		CategoryModel catmodel = null;
		ArrayList<Category> cat = new ArrayList<Category>();
		cat.add((Category) d.readObject());

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

	public IModel getModelByName(String name)
	{
		CategoryModel catmodel = null;
		ArrayList<Category> cat = new ArrayList<Category>();
		cat.add((Category) d.readObject());
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
