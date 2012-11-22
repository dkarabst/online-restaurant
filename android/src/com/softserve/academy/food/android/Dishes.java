package com.softserve.academy.food.android;

import java.util.ArrayList;

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
		
		Button button = (Button) findViewById(R.id.button3);
		button.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				post();
			}
		});
		
//		Button order = (Button) findViewById(R.id.button3);
//		if ( ((Role)getApplicationContext()).isGuest() ) {
//			order.setVisibility(View.INVISIBLE);
//		} else {
//			order.setVisibility(View.VISIBLE);			
//		}
		
	}

	// выводим информацию о корзине
	public void showResult(View v)
	{
		String result = "Товары в корзине:";
		for (DishModel p : boxAdapter.getBox())
		{
			if (p.isBox())
			{
				if (Request.map.containsKey(p.getId()))
				{
					Request.map.put(p.getId(),Request.map.get(p.getId())+1);
				}
				else
				{
					Request.map.put(p.getId(), 1);
				}
				result += "\n" + p.getName();
			}
		}
		Toast.makeText(this, result, Toast.LENGTH_LONG).show();
	}

	// post order
	@SuppressLint("UseSparseArrays")
	public void post()
	{
		if(Request.postOrder()== "true")
		{
			Toast.makeText(this, "We got your order", Toast.LENGTH_SHORT).show();
			Request.map.clear();
		}
		else
		{
			Toast.makeText(this,"try to repeat your order", Toast.LENGTH_SHORT).show();
		}
	}

	public void onClick(View v)
	{
	}
}