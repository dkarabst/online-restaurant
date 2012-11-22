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
import com.softserve.academy.food.android.model.UserModel;

@SuppressLint("UseSparseArrays")
public class Request
{
	final static String							BASE_URL	= "http://192.168.1.3:8080/academy/android";
	public static AndroidMapModel				model;
	public static Map<Integer, Integer>			map;
	public static Map<DishModel, Integer>	modelMap;

	Request()
	{
		StrictMode.enableDefaults();
		if (map == null)
		{
			map = new HashMap<Integer, Integer>();
			modelMap = new HashMap<DishModel, Integer>();
		}
	}
	
	public static String getModels()
	{
		String str="";
		for(DishModel dm : modelMap.keySet())
		{
			str+=dm.getName()+"\n";
		}
		return str;
	}
	
	public static void prepareOrder()
	{
		for(DishModel dm : modelMap.keySet())
		{
			map.put(dm.getId(), modelMap.get(dm));
		}
		modelMap.clear();
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
		return restTemplate.postForObject(url, map, String.class);
	}

	// tolko peredai emy parametr
	public static UserModel getUserInfo(String name)
	{
		String url = BASE_URL + "/userInfo";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJacksonHttpMessageConverter());
		return restTemplate.postForObject(url, name, UserModel.class);
	}

	public static void getDishesByCatId()
	{
		String url = BASE_URL + "/dishesByCategory";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJacksonHttpMessageConverter());
		setModel(restTemplate.getForObject(url, AndroidMapModel.class));
	}
}