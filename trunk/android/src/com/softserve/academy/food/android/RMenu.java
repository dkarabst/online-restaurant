package com.softserve.academy.food.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

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

public class RMenu extends Activity implements OnClickListener
{
	ArrayList<DishModel>	allDishes	= new ArrayList<DishModel>();
	BoxAdapter				boxAdapter;
	// new core has other name Restaurant -> academy
	final String			BASE_URL	= "http://10.0.2.2:8666/Restaurant/android";

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

		Button button_back = (Button) findViewById(R.id.button_back);
		button_back.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				Intent intent_button_back = new Intent(RMenu.this,
						MainActivity.class);
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
		String url = BASE_URL + "/order";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJacksonHttpMessageConverter());
		String result = restTemplate.postForObject(url, map, String.class);
		Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
	}

	// Выбор всех блюд
	public ArrayList<DishModel> getAllDishes()
	{
		String url = BASE_URL + "/dishes";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJacksonHttpMessageConverter());
		DishModel[] arrayDishes = restTemplate.getForObject(url,
				DishModel[].class);
		ArrayList<DishModel> allDishes = new ArrayList<DishModel>(
				Arrays.asList(arrayDishes));
		return allDishes;
	}

	// Выбор блюда по категории
	public ArrayList<DishModel> getDishesById(int id)
	{
		// String url = BASE_URL + "/dish/category/" + new
		// CategoryModel().getId();
		String url = BASE_URL + "/dish/category/" + id;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJacksonHttpMessageConverter());
		DishModel[] allDishes = restTemplate.getForObject(url,
				DishModel[].class);
		ArrayList<DishModel> dishNames = new ArrayList<DishModel>(
				Arrays.asList(allDishes));
		return dishNames;
	}

	public void onClick(View v)
	{
	}
}