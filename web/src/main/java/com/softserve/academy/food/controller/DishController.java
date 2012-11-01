package com.softserve.academy.food.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softserve.academy.food.model.DishModel;
import com.softserve.academy.food.service.DishService;

@Controller
public class DishController
{

	@Autowired
	private DishService	dishService;

	@RequestMapping(value = "/dishes/getDishes", method = RequestMethod.GET)
	protected String getDishes(Model model)
	{
		ArrayList<String> names = new ArrayList<String>();

		for (DishModel mod : dishService.getCategoryList())
		{
			names.add(mod.getName());
		}
		model.addAttribute("helloMessage", names);
		return "helloPage";
	}

	@RequestMapping(value = "/dishes/{id}", method = RequestMethod.GET)
	protected String getDishes(@PathVariable int id,Model model) {
		ArrayList<String> names = new ArrayList<String>();
		DishModel mod = dishService.getById(id);
			names.add(mod.toString());
		model.addAttribute("helloMessage", names);
		return "helloPage";
	}
}
