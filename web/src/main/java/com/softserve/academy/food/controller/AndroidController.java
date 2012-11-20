package com.softserve.academy.food.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserve.academy.food.model.CategoryModel;
import com.softserve.academy.food.model.DishModel;
import com.softserve.academy.food.service.ICategoryService;
import com.softserve.academy.food.service.IMenuService;
import com.softserve.academy.food.service.IOrderService;

@Controller
@RequestMapping(value = "/android")
public class AndroidController
{
	@Autowired
	private ICategoryService	categoryService;

	@Autowired
	private IMenuService		menuService;

	@Autowired
	private IOrderService		orderService;

	@Autowired
	private IMenuService		dishService;

	// all category in list
	@ResponseBody
	@RequestMapping(value = "/cats", method = RequestMethod.GET)
	public ArrayList<CategoryModel> getAllCategories()
	{
		ArrayList<CategoryModel> allCategories = categoryService.getAll();
		return allCategories;
	}

	@ResponseBody
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String makeOrder(@RequestBody Map<Integer, Integer> map)
	{
		String result = "Success";
		try
		{
			orderService.add(map);
		} catch (Exception e)
		{
			result = "fail";
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/dishesByCategory", method = RequestMethod.GET)
	protected Map<CategoryModel, ArrayList<DishModel>> getMenu()
	{
		Map<CategoryModel, ArrayList<DishModel>> map = new HashMap<CategoryModel, ArrayList<DishModel>>();
		for (CategoryModel c : categoryService.getAll())
		{
			map.put(c, dishService.getAllDishesForCategory(c));
		}
		return map;
	}

	// dont know what 4 ?
	// ctegory by id
	@ResponseBody
	@RequestMapping(value = "/cat/{id}", method = RequestMethod.GET)
	public CategoryModel getCategoryById(@PathVariable int id)
	{
		CategoryModel category = categoryService.get(id);
		return category;
	}

	// all dishes
	@ResponseBody
	@RequestMapping(value = "/dishes", method = RequestMethod.GET)
	public ArrayList<DishModel> getAllDishes()
	{
		ArrayList<DishModel> allDishes = menuService.getAllDishes();
		return allDishes;
	}

	// dish by id
	@ResponseBody
	@RequestMapping(value = "/dish/{id}", method = RequestMethod.GET)
	public DishModel getDishById(@PathVariable int id)
	{
		DishModel dish = menuService.getDish(id);
		return dish;
	}

	// dishes by ctegory
	@ResponseBody
	@RequestMapping(value = "/dish/category/{id}", method = RequestMethod.GET)
	public ArrayList<DishModel> getAllDishesByCategory(@PathVariable int id)
	{
		CategoryModel category = categoryService.get(id);
		ArrayList<DishModel> allDishesByCategory = menuService
				.getAllDishesForCategory(category);
		return allDishesByCategory;
	}

}