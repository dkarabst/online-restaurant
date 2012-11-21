package com.softserve.academy.food.android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.softserve.academy.food.android.model.DishModel;

public class Dishes extends Activity implements OnClickListener
{
	ArrayList<DishModel>	allDishes;
	BoxAdapterDish			boxAdapter;
	ListView				lvMain;

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dish);
		StrictMode.enableDefaults();

		Intent intent = getIntent();
		int id = intent.getIntExtra(Categories.MSG, 0);

		// создаем адаптер
		boxAdapter = new BoxAdapterDish(this, Request.getDishListBiId(id));

		// настраиваем список
		lvMain = (ListView) findViewById(R.id.lvMain);
		lvMain.setAdapter(boxAdapter);
		Button button_back = (Button) findViewById(R.id.button_back);
		button_back.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				Intent intent_button_back = new Intent(Dishes.this,
						Categories.class);
				startActivity(intent_button_back);
			}
		});
	}

	// выводим информацию о корзине
	public void showResult(View v)
	{
		String result = "Товары в корзине:";
		for (DishModel p : boxAdapter.getBox())
		{
			if (p.isBox())
				result += "\n" + p.getName();
		}
		Toast.makeText(this, result, Toast.LENGTH_LONG).show();
	}

	// post order
	@SuppressLint("UseSparseArrays")
	public void post()
	{
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (DishModel p : boxAdapter.getBox())
		{
			if (p.isBox())
				// must be quantity instead of 1
				map.put(p.getId(), 1);
		}
		String result = Request.postOrder(map);
		Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
	}

	public void onClick(View v)
	{
	}
}