package com.softserve.academy.food.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.softserve.academy.food.model.CategoryModel;
import com.softserve.academy.food.service.CatService;

public class CatController extends AbstractController
{
	@Override
	@RequestMapping(value="/helloPage.htm", method=RequestMethod.GET)
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		ArrayList<String> names = new ArrayList<String>();

		for (CategoryModel model : CatService.getCategoryList())
		{
			names.add(model.getName());
		}
		return new ModelAndView("helloPage", "helloMessage", names);
	}
}