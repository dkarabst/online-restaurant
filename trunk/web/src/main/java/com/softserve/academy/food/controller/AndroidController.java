package com.softserve.academy.food.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserve.academy.food.model.CategoryModel;
import com.softserve.academy.food.model.DishModel;
import com.softserve.academy.food.service.impl.CategoryService;
import com.softserve.academy.food.service.impl.MenuService;

@Controller
public class AndroidController
{
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private MenuService menuService;

	// ����� ���� ��������� � ������
	@RequestMapping(value = "/cats")
	public @ResponseBody
	ArrayList<CategoryModel> getAllCategories()
	{
		ArrayList<CategoryModel> allCategories = categoryService.getAll();
		return allCategories;
	}

	// ����� ��������� �� id
	@RequestMapping(value = "/cat/{id}")
	public @ResponseBody
	CategoryModel getCategoryById(@PathVariable int id)
	{
		CategoryModel category = categoryService.get(id);
		return category;
	}

	// ����� ���� ���� � ������
	@RequestMapping(value = "/dishes")
	public @ResponseBody
	ArrayList<DishModel> getAllDishes()
	{
		ArrayList<DishModel> allDishes = menuService.getAll();
		return allDishes;
	}

	// ����� ����� �� id
	@RequestMapping(value = "/dish/{id}")
	public @ResponseBody
	DishModel getDishById(@PathVariable int id)
	{
		DishModel dish = menuService.get(id);
		return dish;
	}

	// ����� ����� �� ���������
	@RequestMapping(value = "/dish/category/{id}")
	public @ResponseBody
	ArrayList<DishModel> getAllDishesByCategory(@PathVariable int id)
	{

		CategoryModel category = categoryService.get(id);
		ArrayList<DishModel> allDishesByCategory = menuService.getAll(category);
		return allDishesByCategory;
	}

	/*
	 * @RequestMapping(value="/{id}.json") public ModelAndView
	 * getAllPlayedMatches(@PathVariable int id) { CategoryModel cm =
	 * categoryService.get(id); ModelAndView mav = new ModelAndView();
	 * mav.addObject("cm", cm); return mav; }
	 */
}