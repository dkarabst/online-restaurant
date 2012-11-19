package com.softserve.academy.food.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softserve.academy.food.model.CategoryModel;
import com.softserve.academy.food.model.DishModel;
import com.softserve.academy.food.service.ICategoryService;
import com.softserve.academy.food.service.IMenuService;

@Controller
public class MenuController
{

	@Autowired
	private IMenuService		dishService;

	@Autowired
	private ICategoryService	categoryService;

	// returning map of CategoryModel - List<DishModel>
	// as TODO was
	@RequestMapping(value = "/dishes/all", method = RequestMethod.GET)
	protected String getMenu(Model model)
	{
		Map<CategoryModel, List<DishModel>> map = new HashMap<CategoryModel, List<DishModel>>();
		for (CategoryModel c : categoryService.getAll())
		{
			map.put(c, dishService.getAllDishesForCategory(c));
		}
		model.addAttribute("helloMessage", map);
		return "helloPage";
	}

	@RequestMapping(value = "/dishes/{id}", method = RequestMethod.GET)
	protected String getDish(@PathVariable int id, Model model)
	{
		ArrayList<String> names = new ArrayList<String>();
		DishModel mod = dishService.getDish(id);
		names.add(mod.toString());
		model.addAttribute("helloMessage", names);
		return "helloPage";
	}

}
