package com.softserve.academy.food.android;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
		int id = intent.getIntExtra(CategoryList.MSG, 0);

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
						CategoryList.class);
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

	}

	// выводим информацию о корзине
	public void showResult(View v)
	{
		String result = "Selected items:";
		for (DishModel p : boxAdapter.getBox())
		{
			if (p.isBox())
			{
				result += "\n" + p.getName();
			}
		}
		if (result == "Selected items:")
		{
			Toast.makeText(this, "nothing to add", Toast.LENGTH_LONG).show();
		} else
			showDishDialog(result);
	}

	public void addToBasket()
	{
		for (DishModel p : boxAdapter.getBox())
		{
			if (p.isBox())
			{
				if (Request.modelMap.containsKey(p))
				{
					Request.modelMap.remove(p);
				} else
				{
					Request.modelMap.put(p, 1);
				}
			}
		}
	}

	protected void showDishDialog(String text)
	{
		final AlertDialog alertDialog = new AlertDialog.Builder(this).create();

		alertDialog.setTitle("Items in basket :");
		alertDialog.setMessage(Request.getModels() +"\n"+ text+"\n"
				+ "\n add to basket?");

		alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "yes",
				new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						Toast.makeText(findViewById(R.id.lvMain).getContext(),
								"done", Toast.LENGTH_LONG).show();
						Dishes.this.addToBasket();
					}
				});

		alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "no",
				new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						alertDialog.cancel();
					}
				});

		alertDialog.show();
	}

	// post order
	@SuppressLint("UseSparseArrays")
	public void post()
	{
		if (!((Role) getApplicationContext()).isGuest())
		{
			Request.prepareOrder();
			if (Request.map.size() != 0)
			{
				if (Request.postOrder() == "true")
				{
					Toast.makeText(this, "We got your order",
							Toast.LENGTH_SHORT).show();
					Request.map.clear();
					Request.modelMap.clear();
				} else
				{
					Toast.makeText(this, "something wrong on server",
							Toast.LENGTH_SHORT).show();
				}
			} else
			{
				Toast.makeText(this, "no items in basket", Toast.LENGTH_SHORT)
						.show();
			}
		} else
		{
			Toast.makeText(this, "Please Login/Register", Toast.LENGTH_SHORT)
					.show();
		}
	}

	public void onClick(View v)
	{
	}
}