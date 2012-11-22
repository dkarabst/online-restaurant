package com.softserve.academy.food.controller;

import com.softserve.academy.food.model.CategoryModel;
import com.softserve.academy.food.service.ICategoryService;
import com.softserve.academy.food.service.IMenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

@Controller
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;
    
	@Autowired
	private IMenuService dishService;

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    protected String category( @PathVariable int id, HttpSession session ) {
    	
    	session.setAttribute( "listDishes", dishService.getAllDishesForCategory(categoryService.get(id)) );
    	
    	return "redirect:/";
    }


}