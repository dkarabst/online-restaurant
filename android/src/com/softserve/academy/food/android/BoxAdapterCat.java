package com.softserve.academy.food.android;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.softserve.academy.food.android.model.CategoryModel;

public class BoxAdapterCat extends BaseAdapter
{
	Context						ctx;
	LayoutInflater				lInflater;
	ArrayList<CategoryModel>	allCategories;
	String						catURL	= "http://192.168.1.3:8080/academy/resources/images/dishes/cat";

	BoxAdapterCat(Context context)
	{
		ctx = context;
		allCategories = Request.getCategoryList();
		lInflater = (LayoutInflater) ctx
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	// кол-во элементов
	public int getCount()
	{
		return allCategories.size();
	}

	// элемент по позиции
	public Object getItem(int position)
	{
		return allCategories.get(position);
	}

	// id по позиции
	public long getItemId(int position)
	{
		return position;
	}

	// пункт списка
	public View getView(int position, View convertView, ViewGroup parent)
	{

		// используем созданные, но не используемые view
		View view = convertView;
		if (view == null)
		{
			view = lInflater.inflate(R.layout.itemcat, parent, false);
		}

		CategoryModel categoryModel = ((CategoryModel) getItem(position));

		// заполняем View в пункте списка данными из товаров: наименование, цена
		// и картинка
		((TextView) view.findViewById(R.id.tvName1)).setText(categoryModel
				.getName());
		ImageView ivImage = (ImageView) view.findViewById(R.id.ivImage1);

		try
		{
			new Request();
			
			if (categoryModel.getId() < 10)
			{
				Bitmap	bitmap = BitmapFactory.decodeStream((InputStream) new URL(
						catURL + "0" + categoryModel.getId() + "/Category.jpg")
						.getContent());
				ivImage.setImageBitmap(bitmap);
			} else
			{
				Bitmap bitmap = BitmapFactory.decodeStream((InputStream) new URL(
						catURL + categoryModel.getId() + "/Category.jpg")
						.getContent());
				ivImage.setImageBitmap(bitmap);
			}
		} catch (MalformedURLException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return view;
	}
}