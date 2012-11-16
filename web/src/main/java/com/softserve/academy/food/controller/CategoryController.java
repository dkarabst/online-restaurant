package com.softserve.academy.food.controller;

import com.softserve.academy.food.model.CategoryModel;
import com.softserve.academy.food.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/category/all", method = RequestMethod.GET)
    protected String categoryList(Model model) {
        ArrayList<String> names = new ArrayList<String>();

        for (CategoryModel mod : categoryService.getAll()) {
            names.add(mod.toString());
        }
        model.addAttribute("helloMessage", names);
        return "helloPage";
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String add(Model model) {
        return "categoryAdd";
    }

    @RequestMapping(value = "/category/add", method = RequestMethod.POST)
    public String added(@ModelAttribute("categoryModel") CategoryModel categoryModel, Model model) {
        categoryService.add(categoryModel);
        return "redirect:../category";
    }

    @RequestMapping(value = "/delcategory", method = RequestMethod.GET)
    public String delete(Model model) {
        return "deleteCategory";
    }

    @RequestMapping(value = "/delcategory/delete", method = RequestMethod.POST)
    public String deleted(@RequestParam("name") String name, Model model) {
        categoryService.delete(Integer.parseInt(name));
        return "redirect:../delcategory";
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    protected String category(@PathVariable int id, Model model) {
        ArrayList<String> names = new ArrayList<String>();
        CategoryModel mod = categoryService.get(id);
        names.add(mod.toString());
        model.addAttribute("helloMessage", names);
        return "helloPage";
    }
}