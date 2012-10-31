package com.softserve.academy.food.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softserve.academy.food.model.CategoryModel;
import com.softserve.academy.food.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/helloPage.htm", method = RequestMethod.GET)
	protected String helloPage(Model model) {
		ArrayList<String> names = new ArrayList<String>();

		for (CategoryModel mod : categoryService.getCategoryList()) {
			names.add(mod.getName());
		}
		model.addAttribute("helloMessage", names);
		return "helloPage";
	}

	private static final Logger logger = LoggerFactory
			.getLogger(CategoryController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is " + locale.toString());

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}
}