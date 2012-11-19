package com.softserve.academy.food.controller;

import java.util.ArrayList;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.softserve.academy.food.entity.User;
import com.softserve.academy.food.model.UserCredentials;
import com.softserve.academy.food.service.UserService;

@Controller
@SessionAttributes("user")
public class UserController
{
	@Autowired
	private UserService userService;

	 @RequestMapping(value = "/register", method = RequestMethod.GET)
	 	    public String showRegisterForm(ModelMap model) {
	 	        model.addAttribute(new UserCredentials(new User()));
	 	        return "userForm";
	 	    }
	 
	  @RequestMapping(method = RequestMethod.POST)
	  	    public String onSubmit(@ModelAttribute("usercredentials") UserCredentials user) {
		      userService.add(user);
	  	        return "RegisterState";
	  	    }
	  	
}