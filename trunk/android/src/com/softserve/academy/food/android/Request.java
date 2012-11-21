package com.softserve.academy.food.android;

import java.util.ArrayList;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.os.StrictMode;

import com.softserve.academy.food.android.model.AndroidMapModel;
import com.softserve.academy.food.android.model.CategoryModel;
import com.softserve.academy.food.android.model.DishModel;

public class Request
{
	final static String				BASE_URL	= "http://192.168.1.3:8080/academy/android";
	public static AndroidMapModel	model;

	Request()
	{
		StrictMode.enableDefaults();
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