package com.softserve.academy.food.android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.os.StrictMode;

import com.softserve.academy.food.android.model.CategoryModel;
import com.softserve.academy.food.android.model.DishModel;

public class Request
{
	final static String	BASE_URL	= "http://10.0.2.2:8080/academy/android";
	public static Map<CategoryModel, ArrayList<DishModel>> map;
	public static ArrayList<CategoryModel> acm;
	
	Request()
	{
		StrictMode.enableDefaults();
	}

	public static Map<CategoryModel, ArrayList<DishModel>> getMap()
	{
		return map;
	}



	public static void setMap(Map<CategoryModel, ArrayList<DishModel>> map)
	{
		Request.map = map;
	}



	public static ArrayList<CategoryModel> getAcm()
	{
		return acm;
	}



	public static void setAcm(ArrayList<CategoryModel> acm)
	{
		Request.acm = acm;
	}

	// Выбор блюда по категории
	@SuppressWarnings("unchecked")
	public static Map<CategoryModel, ArrayList<DishModel>> getDishesByCatId()
	{
		String url = BASE_URL + "/dishesByCategory";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJacksonHttpMessageConverter());
		return (HashMap<CategoryModel, ArrayList<DishModel>>) restTemplate
				.getForObject(url, HashMap.class);
	}
}