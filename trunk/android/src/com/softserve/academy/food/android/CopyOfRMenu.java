package com.softserve.academy.food.android;

import java.util.ArrayList;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.softserve.academy.food.android.model.CategoryModel;
import com.softserve.academy.food.android.model.DishModel;
public class CopyOfRMenu extends Activity implements OnClickListener
{
	ListView lvDishes;
	String[] names;
	final String BASE_URL = "http://10.0.2.2:8666";


	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rmenu);
		
		StrictMode.enableDefaults();
		
		LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linlayout);
        linearLayout.setBackgroundColor(Color.rgb(160, 200, 240));
		lvDishes = (ListView) findViewById(R.id.lvDishes);
		// устанавливаем режим выбора пунктов списка
		lvDishes.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

		// Создаем адаптер, используя массив, полученный от сервера		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_list_item_multiple_choice, getAllDishes());
		lvDishes.setAdapter(adapter);
		
		Button btnChecked = (Button) findViewById(R.id.btnChecked);
		Button button_back = (Button) findViewById(R.id.button_back);
		// Установка слушателей для кнопок
		btnChecked.setOnClickListener(this);
		button_back.setOnClickListener(this);
	}

	public void onClick(View arg0)
	{
		Intent intent_button_back = new Intent(CopyOfRMenu.this, MainActivity.class);
		startActivity(intent_button_back);
	}
// Выбор блюда по категории	
	public ArrayList<String> getDishesById(int id)
	{
		String url = BASE_URL + "/Restaurant/dish/category/" + new CategoryModel().getId();
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		DishModel[] allDishes = restTemplate.getForObject(url, DishModel[].class);
		ArrayList<String> dishNames = new ArrayList<String>();
		dishNames = new ArrayList<String>();
		for (DishModel dishModel : allDishes)
		{
			dishNames.add(dishModel.getName());
		}
		return dishNames;
	}
	// Выбор всех блюд	
	public ArrayList<String> getAllDishes()
	{
		String url = BASE_URL + "/Restaurant/dishes";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		DishModel[] allDishes = restTemplate.getForObject(url, DishModel[].class);
		ArrayList<String> dishNames = new ArrayList<String>();
		dishNames = new ArrayList<String>();
		for (DishModel dishModel : allDishes)
		{
			dishNames.add(dishModel.getName());
		}
		return dishNames;
	}

}