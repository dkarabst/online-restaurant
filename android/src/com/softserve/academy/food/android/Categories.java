package com.softserve.academy.food.android;

import java.util.ArrayList;

import com.softserve.academy.food.android.model.CategoryModel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class Categories extends Activity implements OnItemClickListener
{
	BoxAdapterCat				boxAdapterCats;
	static ListView				lvMain1;
	public static final String	MSG	= "category";

	@SuppressWarnings("unchecked")
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.categories);

		StrictMode.enableDefaults();

		// создаем адаптер
		boxAdapterCats = new BoxAdapterCat(this,
				((ArrayList<CategoryModel>) MainActivity.map.keySet()));

		// настраиваем список
		lvMain1 = (ListView) findViewById(R.id.lvMain1);
		lvMain1.setAdapter(boxAdapterCats);
		lvMain1.setOnItemClickListener(this);

		Button button_back = (Button) findViewById(R.id.button_back);
		button_back.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				Intent intent_button_back = new Intent(Categories.this,
						MainActivity.class);
				startActivity(intent_button_back);
			}
		});
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
	{
		Intent intent = new Intent(Categories.this, Dishes.class);
		intent.putExtra("category", arg2);
		startActivity(intent);
	}
}