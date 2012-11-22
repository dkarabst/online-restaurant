package com.softserve.academy.food.android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.annotation.SuppressLint;
import android.os.StrictMode;

import com.softserve.academy.food.android.model.AndroidMapModel;
import com.softserve.academy.food.android.model.CategoryModel;
import com.softserve.academy.food.android.model.DishModel;

@SuppressLint("UseSparseArrays")
public class Request
{
	final static String				BASE_URL	= "http://192.168.1.3:8080/academy/android";
	public static AndroidMapModel	model;
	public static Map<Integer, Integer> map;

	Request()
	{
		StrictMode.enableDefaults();
		if (map == null)
		{
			map = new HashMap<Integer, Integer>(); 
		}
	}

	public static AndroidMapModel getModel()
	{
		return model;
	}

	public static void setModel(AndroidMapModel model)
	{
		Request.model = model;
	}

	public static ArrayList<CategoryModel> getCategoryList()
	{
		return new ArrayList<CategoryModel>(model.getCategoryList().values());
	}

	public static ArrayList<DishModel> getDishListBiId(int id)
	{
		return model.getDishesList().get(id);
	}
	
	public static String postOrder()
	{
		String url = BASE_URL + "/order";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJacksonHttpMessageConverter());
		return  restTemplate.postForObject(url, map, String.class);
	}

	// Выбор блюда по категории
	public static void getDishesByCatId()
	{
		String url = BASE_URL + "/dishesByCategory";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJacksonHttpMessageConverter());
		setModel(restTemplate.getForObject(url, AndroidMapModel.class));
	}
}