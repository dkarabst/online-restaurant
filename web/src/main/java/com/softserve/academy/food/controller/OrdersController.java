package com.softserve.academy.food.controller;

import com.softserve.academy.food.model.OrderModel;
import com.softserve.academy.food.service.impl.OrderHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/orders")
public class OrdersController
{

	@Autowired
	private OrderHistoryService	orderHistoryService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listContacts(Map<String, Object> map)
	{

		map.put("order", new OrderModel());
		map.put("orderList", orderHistoryService.getAllModels());
		return "order";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("order") Integer order,
			BindingResult result)
	{ // not sure with the attributes

		orderHistoryService.getModelById(order);
		return "redirect:/orders/list";
	}

	@RequestMapping("/delete/{orderId}")
	public String deleteContact(@PathVariable("orderId") Integer orderId)
	{

		orderHistoryService.delModelById(orderId);
		return "redirect:/orders/list";
	}
}
