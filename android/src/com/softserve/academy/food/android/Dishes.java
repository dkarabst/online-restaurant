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

		boxAdapter = new BoxAdapterDish(this, Request.getDishListBiId(id));

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

	public void showResult(View v)
	{
		String result = getString(R.string.selected);
		for (DishModel p : boxAdapter.getBox())
		{
			if (p.isBox())
			{
				result += "\n" + p.getName();
			}
		}
		if (result == getString(R.string.selected))
		{
			Toast.makeText(this, getString(R.string.nothing), Toast.LENGTH_SHORT).show();
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

		alertDialog.setTitle(getString(R.string.items));
		alertDialog.setMessage(Request.getModels() + "\n" + text + "\n"
				+ "\n"+getString(R.string.question));

		alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, getString(R.string.yes),
				new DialogInterface.OnClickListener()
				{
					public void onClick(DialogInterface dialog, int which)
					{
						Toast.makeText(findViewById(R.id.lvMain).getContext(),
								getString(R.string.done), Toast.LENGTH_SHORT).show();
						Dishes.this.addToBasket();
					}
				});

		alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, getString(R.string.no),
				new DialogInterface.OnClickListener()
				{
					public void onClick(DialogInterface dialog, int which)
					{
						alertDialog.cancel();
					}
				});

		alertDialog.show();
	}
	
	protected void showLoginDialog()
	{
		final AlertDialog alertDialog = new AlertDialog.Builder(this).create();

		alertDialog.setTitle(getString(R.string.login));
		alertDialog.setMessage(getString(R.string.lpage));

		alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, getString(R.string.yes),
				new DialogInterface.OnClickListener()
				{
					public void onClick(DialogInterface dialog, int which)
					{
						Intent intent_login = new Intent(Dishes.this, LoginActivity.class);
						startActivity(intent_login);
					}
				});

		alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, getString(R.string.no),
				new DialogInterface.OnClickListener()
				{
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
					Toast.makeText(this, getString(R.string.wgot),
							Toast.LENGTH_SHORT).show();
					Request.map.clear();
					Request.modelMap.clear();
				} else
				{
					Toast.makeText(this, getString(R.string.server),
							Toast.LENGTH_SHORT).show();
				}
			} else
			{
				Toast.makeText(this, getString(R.string.noitems), Toast.LENGTH_SHORT)
						.show();
			}
		} else
		{
			showLoginDialog();
		}
	}

	public void onClick(View v)
	{
	}
}