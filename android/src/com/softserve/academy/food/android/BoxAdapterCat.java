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
	Context ctx;
	LayoutInflater lInflater;
	
	ArrayList<CategoryModel> allCategories = Request.getAllCategories();

	BoxAdapterCat(Context context, ArrayList<CategoryModel> products)
	{
		ctx = context;
		allCategories = products;
		lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	// ���-�� ���������
	public int getCount()
	{
		return allCategories.size();
	}

	// ������� �� �������
	public Object getItem(int position)
	{
		return allCategories.get(position);
	}

	// id �� �������
	public long getItemId(int position)
	{
		return position;
	}

	// ����� ������
	public View getView(int position, View convertView, ViewGroup parent)
	{
	
		// ���������� ���������, �� �� ������������ view
		View view = convertView;
		if (view == null)
		{
			view = lInflater.inflate(R.layout.itemcat, parent, false);
		}

		CategoryModel categoryModel = ((CategoryModel) getItem(position));

		// ��������� View � ������ ������ ������� �� �������: ������������, ����
		// � ��������
		((TextView) view.findViewById(R.id.tvName1)).setText(
				"*  *  *  *  *  *  *  *  *  *  *  *  *  *  *\n" + 
				categoryModel.getName() + 
				"\n*  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
		ImageView ivImage = (ImageView) view.findViewById(R.id.ivImage1);

		try
		{
			new Request();
			Bitmap bitmap = BitmapFactory.decodeStream((InputStream) new URL(
					Request.BASE_URL + categoryModel.getPhoto()).getContent());
			ivImage.setImageBitmap(bitmap);
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