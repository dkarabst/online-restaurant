package com.softserve.academy.food.controller;

import com.softserve.academy.food.model.DishModel;
import com.softserve.academy.food.service.impl.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class MenuController {

    @Autowired
    private MenuService dishService;

    @RequestMapping(value = "/dishes/all", method = RequestMethod.GET)
    protected String getMenu(Model model) {
        //TODO return model with map category:dishList
        return "helloPage";
    }

    @RequestMapping(value = "/dishes/{id}", method = RequestMethod.GET)
    protected String getDish(@PathVariable int id, Model model) {
        ArrayList<String> names = new ArrayList<String>();
        DishModel mod = dishService.getDish(id);
        names.add(mod.toString());
        model.addAttribute("helloMessage", names);
        return "helloPage";
    }

}
