package com.softserve.academy.food.controller;

import com.softserve.academy.food.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class OrderController {

    @Autowired
    private IOrderService orderService;

//TODO
//    @RequestMapping(value = "/order", method = RequestMethod.GET)
//    public String add(Model model) {
//        return "addOrder";
//    }

    @RequestMapping(value = "/order/add", method = RequestMethod.POST)
    public String add(@RequestParam("name") String name, Model model) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(Integer.parseInt(name));
        //TODO
//        orderService.add(1, list);
        return "redirect:../order";
    }

}
