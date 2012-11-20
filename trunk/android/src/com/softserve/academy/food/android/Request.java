package com.softserve.academy.food.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.os.StrictMode;
import android.widget.Toast;

import com.softserve.academy.food.android.model.CategoryModel;
import com.softserve.academy.food.android.model.DishModel;
public class Request
{
	final static String BASE_URL = "http://10.0.2.2:8666/Restaurant/android";
	
	Request()
	{
		StrictMode.enableDefaults();	
	}
	// post order
/*	public void post()
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
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		String result = restTemplate.postForObject(url, map, String.class);
		Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
	}
*/
	// get all categories	
	public static ArrayList<CategoryModel> getAllCategories()
	{
		String url = BASE_URL + "/cats";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		CategoryModel[] allCategories = restTemplate.getForObject(url, CategoryModel[].class);
		ArrayList<CategoryModel> categoryNames = new ArrayList<CategoryModel>(Arrays.asList(allCategories));
		return categoryNames;
	}

	// Выбор всех блюд	
	public static ArrayList<DishModel> getAllDishes()
	{
		String url = BASE_URL + "/dishes";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		DishModel[] arrayDishes = restTemplate.getForObject(url, DishModel[].class);
		ArrayList<DishModel> allDishes = new ArrayList<DishModel>(Arrays.asList(arrayDishes));
		return allDishes;
	}
	
	// Выбор блюда по категории	
	public static ArrayList<DishModel> getDishesByCatId(int id)
	{
		String url = BASE_URL + "/dish/category/" + String.valueOf(id);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		DishModel[] allDishes = restTemplate.getForObject(url, DishModel[].class);
		ArrayList<DishModel> dishNames = new ArrayList<DishModel>(Arrays.asList(allDishes));
		return dishNames;
	}
}