package com.softserve.academy.food.controller;

import com.softserve.academy.food.model.OrderModel;
import com.softserve.academy.food.service.impl.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private OrderHistoryService orderHistoryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listContacts(Map<String, Object> map) {

        map.put("order", new OrderModel());
        map.put("orderList", orderHistoryService.getUserHistory());
        return "order";
    }

}
