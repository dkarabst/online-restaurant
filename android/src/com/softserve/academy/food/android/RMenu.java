package com.softserve.academy.food.android;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.softserve.academy.food.android.model.CategoryModel;
import com.softserve.academy.food.android.model.DishModel;
public class RMenu extends Activity implements OnClickListener
{
	ArrayList<DishModel> allDishes = new ArrayList<DishModel>();
	BoxAdapter boxAdapter;
	final String BASE_URL = "http://10.0.2.2:8666/Restaurant/android";

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rmenu);
		
		StrictMode.enableDefaults();
	
		// создаем адаптер
		boxAdapter = new BoxAdapter(this, getAllDishes());

		// настраиваем список
		ListView lvMain = (ListView) findViewById(R.id.lvMain);
		lvMain.setAdapter(boxAdapter);
		
		Button button_back  = (Button) findViewById(R.id.button_back);
		button_back.setOnClickListener(new View.OnClickListener() 
		
		{
			public void onClick(View v)
			{
				Intent intent_button_back = new Intent(RMenu.this, MainActivity.class);
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
	
	// Выбор всех блюд	
	public ArrayList<DishModel> getAllDishes()
	{
		String url = BASE_URL + "/dishes";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		DishModel[] arrayDishes = restTemplate.getForObject(url, DishModel[].class);
		ArrayList<DishModel> allDishes = new ArrayList<DishModel>(Arrays.asList(arrayDishes));
		return allDishes;
	}
	
	// Выбор блюда по категории	
	public ArrayList<DishModel> getDishesById(int id)
	{
		String url = BASE_URL + "/dish/category/" + new CategoryModel().getId();
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		DishModel[] allDishes = restTemplate.getForObject(url, DishModel[].class);
		ArrayList<DishModel> dishNames = new ArrayList<DishModel>(Arrays.asList(allDishes));
		return dishNames;
	}

	public void onClick(View v)
	{}
}