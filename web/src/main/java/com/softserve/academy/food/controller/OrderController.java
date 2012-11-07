package com.softserve.academy.food.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

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
@RequestMapping("/order")
public class OrderController
{

	@Autowired
	private OrderService	orderService;
	
	//temporal
	private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	@RequestMapping(value = "/all", method = RequestMethod.GET)
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

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String add(Model model)
	{
		return "addOrder";
	}

	@RequestMapping(value = "/addDish", method = RequestMethod.POST)
	public String addDish(@RequestParam("dish_id") int dish_id,@RequestParam("quantity") int quantity, Model model,
			HttpSession session)
	{
//		@SuppressWarnings("unchecked")
		// HashMap<Integer,Integer> map  must be created my sign in..  
//		HashMap<Integer,Integer> map = (HashMap<Integer,Integer>) session.getAttribute("dishList");
		if(map.containsKey(dish_id))
		{
			map.put(dish_id, (map.get(dish_id)+quantity));
		}
		else
		{
			map.put(dish_id, quantity);
		}
		session.setAttribute("dishList", map);
		return "redirect:../order";
	}

	@RequestMapping(value = "/makeOrder", method = RequestMethod.GET)
	public String makeOrder( Model model,HttpSession session)
	{
		// temporal
//		Integer user_id = session.getAttribute("user_id");
		// user id =1 , because we dont have security now
		orderService.add(1, session.getAttribute("dishList"));
		return "redirect:../order";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	protected String category(@PathVariable int id, Model model)
	{
		ArrayList<String> names = new ArrayList<String>();
		OrderModel mod = orderService.get(id);
		names.add(mod.toString());
		model.addAttribute("helloMessage", names);
		return "helloPage";
	}

}
