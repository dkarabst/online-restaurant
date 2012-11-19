package com.softserve.academy.food.controller;

import com.softserve.academy.food.entity.Category;
import com.softserve.academy.food.service.CategoryService;
import com.softserve.academy.food.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class AndroidController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private MenuService menuService;

    // all category in list 
    @RequestMapping(value = "/android/cats")
    @ResponseBody
    public ArrayList<Category> getAllCategories() {
        ArrayList<Category> allCategories = categoryService.getAll();
        return allCategories;
    }

    //ctegory by id
    @RequestMapping(value = "/android/cat/{id}")
    @ResponseBody
    public CategoryModel getCategoryById(@PathVariable int id) {
        CategoryModel category = categoryService.get(id);
        return category;
    }

    // all dishes
    @RequestMapping(value = "/android/dishes")
    @ResponseBody
    public ArrayList<DishModel> getAllDishes() {
        ArrayList<DishModel> allDishes = menuService.getAllDishes();
        return allDishes;
    }

    //dish by id
    @RequestMapping(value = "/android/dish/{id}")
    public
    @ResponseBody
    DishModel getDishById(@PathVariable int id) {
        DishModel dish = menuService.getDish(id);
        return dish;
    }

    // dishes by ctegory
    @RequestMapping(value = "/android/dish/category/{id}")
    @ResponseBody
    public ArrayList<DishModel> getAllDishesByCategory(@PathVariable int id) {
        CategoryModel category = categoryService.get(id);
        ArrayList<DishModel> allDishesByCategory = menuService.getAllDishesForCategory(category);
        return allDishesByCategory;
    }

}