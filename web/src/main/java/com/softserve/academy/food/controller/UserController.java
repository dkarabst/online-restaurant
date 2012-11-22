package com.softserve.academy.food.controller;

import java.util.ArrayList;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
import com.softserve.academy.food.service.IUserService;

@Controller
public class UserController
{
	@Autowired
	private IUserService userService;

	 @RequestMapping(value = "/register", method = RequestMethod.GET)
	 	    public String showRegisterForm(ModelMap model) {
	 	        model.addAttribute(new UserCredentials(new User()));
	 	        return "userForm";
	 	    }
	 

	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String showUser( ModelMap model ) {
		
		model.addAttribute( "userinfo", userService.getUser() );
		model.addAttribute( "login", getLogin() );
		return "userinfo";
	}
	  
    private String getLogin() {
        String login = "guest";

        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            if (principal instanceof UserDetails) {
                login = ((UserDetails) principal).getUsername();
            } else {
                login = principal.toString();
            }
        } catch (NullPointerException e) {

        }
        return login;
    }
	  	
}