package com.softserve.academy.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.softserve.academy.food.model.CategoryModel;
import com.softserve.academy.food.service.CategoryService;

@Controller
public class AndroidController
{
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/lookup")
	public ModelAndView getAllPlayedMatches() {
	   CategoryModel cm = categoryService.getById(4);
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("cm", cm);
	    return mav;
	}
}
