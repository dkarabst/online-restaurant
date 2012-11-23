package com.softserve.academy.food.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserve.academy.food.model.AndroidMapModel;
import com.softserve.academy.food.model.CategoryModel;
import com.softserve.academy.food.model.DishModel;
import com.softserve.academy.food.model.UserCredentials;
import com.softserve.academy.food.model.UserModel;
import com.softserve.academy.food.service.ICategoryService;
import com.softserve.academy.food.service.IMenuService;
import com.softserve.academy.food.service.IOrderService;
import com.softserve.academy.food.service.IUserService;

@Controller
@RequestMapping(value = "/android")
public class AndroidController
{
	@Autowired
	private ICategoryService	categoryService;

	@Autowired
	private IUserService		userService;

	@Autowired
	private IOrderService		orderService;

	@Autowired
	private IMenuService		dishService;

	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String makeOrder(@RequestBody ArrayList<Object> obj)
	{
		List<Integer> ids =(ArrayList<Integer>)obj.get(0);
		List<Integer> col = (ArrayList<Integer>)obj.get(1); 
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for( int i=0; i<ids.size(); i++)
		{
			map.put(ids.get(i),col.get(i));
		}
		String result = "true";
		try
		{
			orderService.addAndroid(map,(Integer)obj.get(2));
		}catch(Exception e)
		{
			System.out.println(e);
			result = "false";
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public UserModel newUser(@RequestBody Object obj)
	{
		
		 @SuppressWarnings("unchecked")
		 ArrayList<String> info = (ArrayList<String>) obj;
		 UserCredentials uc = new UserCredentials(info.get(0),info.get(1));
		 String result = "true";
		 UserModel um = new UserModel();
		 try {
			 if(userService.add(uc))
			 {
				 um = userService.getUser(info.get(0));
				 um.setEmail(info.get(2));
				 um.setPhone(info.get(3));
				 userService.update(um);
			 }
		 }catch (Exception e)
		 {
			 System.out.println(e);
			 result = "false";
		 }
		return um;
	}
	
	@ResponseBody
	@RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
	public UserModel getUser(@PathVariable String name)
	{
		return userService.getUser(name);
	}

	@ResponseBody
	@RequestMapping(value = "/dishesByCategory", method = RequestMethod.GET)
	protected AndroidMapModel getMenu()
	{
		AndroidMapModel model = new AndroidMapModel();
		SortedMap<Integer ,CategoryModel> categoryList = new TreeMap<Integer ,CategoryModel>();
		SortedMap<Integer ,ArrayList<DishModel>> dishesList = new TreeMap<Integer ,ArrayList<DishModel>>();
		for (CategoryModel c : categoryService.getAll())
		{
			categoryList.put((Integer)c.getId(), c);
			dishesList.put((Integer)c.getId(),dishService.getAllDishesForCategory(c));
		}
		model.setCategoryList(categoryList);
		model.setDishesList(dishesList);
		return model;
	}

}