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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.softserve.academy.food.android.model.DishModel;

public class BoxAdapterDish extends BaseAdapter
{
	Context					ctx;
	LayoutInflater			lInflater;
	ArrayList<DishModel>	dishByCategory;
	String dishURL  = "http://192.168.1.3:8080/academy/resources/";

	BoxAdapterDish(Context context, ArrayList<DishModel> products)
	{
		ctx = context;
		dishByCategory = products;
		lInflater = (LayoutInflater) ctx
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	// ���-�� ���������
	public int getCount()
	{
		return dishByCategory.size();
	}

	// ������� �� �������
	public Object getItem(int position)
	{
		return dishByCategory.get(position);
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
			view = lInflater.inflate(R.layout.item, parent, false);
		}

		DishModel dishModel = ((DishModel) getItem(position));

		// ��������� View � ������ ������ ������� �� �������: ������������, ����
		// � ��������
		((TextView) view.findViewById(R.id.tvName))
				.setText(dishModel.getName());
		((TextView) view.findViewById(R.id.tvPrice)).setText("����: "
				+ dishModel.getPrice() + " ���");
		ImageView ivImage = (ImageView) view.findViewById(R.id.ivImage);

		try
		{
			Bitmap bitmap = BitmapFactory.decodeStream((InputStream) new URL(
					dishURL + dishModel.getPhoto()).getContent());
			ivImage.setImageBitmap(bitmap);
		} catch (MalformedURLException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		CheckBox cbBuy = (CheckBox) view.findViewById(R.id.cbBox);
		// ����������� �������� ����������
		cbBuy.setOnCheckedChangeListener(myCheckChangList);
		// ����� �������
		cbBuy.setTag(position);
		// ��������� ������� �� �������: � ������� ��� ���
		cbBuy.setChecked(dishModel.isBox());
		return view;
	}

	// ����� �� �������
	DishModel getDishModel(int position)
	{
		return ((DishModel) getItem(position));
	}

	// ���������� �������
	ArrayList<DishModel> getBox()
	{
		ArrayList<DishModel> box = new ArrayList<DishModel>();
		for (DishModel dishModel : dishByCategory)
		{
			// ���� � �������
			if (dishModel.isBox())
				box.add(dishModel);
		}
		return box;
	}

	// ���������� ��� ���������
	OnCheckedChangeListener	myCheckChangList	= new OnCheckedChangeListener()
												{
													public void onCheckedChanged(
															CompoundButton buttonView,
															boolean isChecked)
													{
														// ������ ������ ������
														// (� ������� ��� ���)
														getDishModel(
																(Integer) buttonView
																		.getTag())
																.setBox(isChecked);
													}
												};
}