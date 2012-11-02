package com.softserve.academy.food.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.softserve.academy.food.model.OrderModel;
import com.softserve.academy.food.service.OrderService;

@Controller
public class OrderController
{

	@Autowired
	private OrderService	orderService;

	// @Autowired
	// private UserService userService;

	@RequestMapping(value = "/order/all", method = RequestMethod.GET)
	protected String categoryList(Model model)
	{
		ArrayList<String> names = new ArrayList<String>();

		for (OrderModel mod : orderService.getAll())
		{
			names.add(mod.toString());
		}
		model.addAttribute("helloMessage", names);
		return "helloPage";
	}

	 @RequestMapping(value = "/order", method = RequestMethod.GET)
	 public String add(Model model) {
	 return "addOrder";
	 }
	 
	 @RequestMapping(value = "/order/add", method = RequestMethod.POST)
	 public String added(@RequestParam("name") String name, Model model) {
		 ArrayList<Integer> list =  new ArrayList<Integer>();
		 list.add(Integer.parseInt(name));
	 orderService.add(1,list);
	 return "redirect:../order";
	 }
	
	 @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
	 protected String category(@PathVariable int id,Model model) {
	 ArrayList<String> names = new ArrayList<String>();
	 OrderModel mod = orderService.get(id);
	 names.add(mod.toString());
	 model.addAttribute("helloMessage", names);
	 return "helloPage";
	 }

}
