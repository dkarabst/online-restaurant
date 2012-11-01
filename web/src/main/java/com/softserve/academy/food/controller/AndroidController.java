package com.softserve.academy.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.softserve.academy.food.model.CategoryModel;
import com.softserve.academy.food.service.CategoryService;

@Controller
public class AndroidController
{
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/{id}.json")
	public ModelAndView getAllPlayedMatches(@PathVariable int id) {
	   CategoryModel cm = categoryService.get(id);
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("cm", cm);
	    return mav;
	}
}
