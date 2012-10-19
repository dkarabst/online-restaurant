package com.softserve.academy.food.xml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

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
					"D:\\CategorySimple.xml")));
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			d = new XMLDecoder(new FileInputStream(new File(
					"D:\\CategorySimple.xml")));
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addModel(CategorySimple cat) throws ClassNotFoundException,
			FileNotFoundException
	{
		e.writeObject(cat);
		e.close();
	}

	public ArrayList<CategoryModel> getAllModels() throws FileNotFoundException
	{
		ArrayList<CategorySimple> cat = new ArrayList<CategorySimple>();
		cat.add((CategorySimple) d.readObject());
		CategoryModel model = null;
		ArrayList<CategoryModel> modelList = new ArrayList<CategoryModel>();
		for (CategorySimple entity : cat)
		{
			model = new CategoryModel(entity.getId(), entity.getName());
			modelList.add(model);
		}
		d.close();
		return modelList;
	}

	public void delModelById(int id)
	{
		ArrayList<CategorySimple> cat = new ArrayList<CategorySimple>();
		cat.add((CategorySimple) d.readObject());
		for (int i = 0; i < cat.size(); i++)
		{
			CategorySimple c = cat.get(i);
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
		ArrayList<CategorySimple> cat = new ArrayList<CategorySimple>();
		cat.add((CategorySimple) d.readObject());

		for (int i = 0; i < cat.size(); i++)
		{
			CategorySimple c = cat.get(i);
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
		ArrayList<CategorySimple> cat = new ArrayList<CategorySimple>();
		cat.add((CategorySimple) d.readObject());

		for (int i = 0; i < cat.size(); i++)
		{
			CategorySimple c = (CategorySimple) cat.get(i);
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
		ArrayList<CategorySimple> cat = new ArrayList<CategorySimple>();
		cat.add((CategorySimple) d.readObject());
		for (int i = 0; i < cat.size(); i++)
		{
			CategorySimple c = cat.get(i);
			if (c.getName().equals(name))
			{
				catmodel = new CategoryModel(c.getId(), c.getName());
			}
		}
		d.close();
		return catmodel;
	}

}
