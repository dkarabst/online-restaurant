package com.softserve.academy.food.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	protected String viewMenu( Model model, HttpSession session )
	{
		model.addAttribute( "listDishes", dishService.getAllDishes() );
		model.addAttribute( "listCategory", categoryService.getAll() );
		
		if ( session.getAttribute("listDishes")!=null )
		{
			model.addAttribute("listDishes", (ArrayList<DishModel>)session.getAttribute("listDishes"));
		}
		else
		{
			session.setAttribute( "listDishes", dishService.getAllDishes() );
		}

		return "menu";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	protected String view( )
	{
		return "redirect:/";
	}

	@RequestMapping(value = "/dishes/{id}", method = RequestMethod.GET)
	protected String getDish(@PathVariable int id, Model model )
	{
		model.addAttribute( "dish", dishService.getDish(id) );
		return "dishesinfo";
	}

}
