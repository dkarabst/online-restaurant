package com.softserve.academy.food.controller;

import java.util.ArrayList;

import com.softserve.academy.food.service.CatService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class CatController extends AbstractController {
	
	ArrayList<String> categoryList;
	String message;
	
	public CatController() {
		CatService service = new CatService();
		this.categoryList = service.getCategoryList();		
		message = service.getById(5);
		
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		return new ModelAndView("helloPage","helloMessage", message);
	}
}