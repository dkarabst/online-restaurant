package com.softserve.academy.food.controller;

import com.softserve.academy.food.model.CategoryModel;
import com.softserve.academy.food.model.DishModel;
import com.softserve.academy.food.service.ICategoryService;
import com.softserve.academy.food.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class AndroidController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IMenuService menuService;

    // ����� ���� ��������� � ������
    @RequestMapping(value = "/android/cats")
    @ResponseBody
    public ArrayList<CategoryModel> getAllCategories() {
        ArrayList<CategoryModel> allCategories = categoryService.getAll();
        return allCategories;
    }

    // ����� ��������� �� id
    @RequestMapping(value = "/android/cat/{id}")
    @ResponseBody
    public CategoryModel getCategoryById(@PathVariable int id) {
        CategoryModel category = categoryService.get(id);
        return category;
    }

    // ����� ���� ���� � ������
    @RequestMapping(value = "/android/dishes")
    @ResponseBody
    public ArrayList<DishModel> getAllDishes() {
        ArrayList<DishModel> allDishes = menuService.getAllDishes();
        return allDishes;
    }

    // ����� ����� �� id
    @RequestMapping(value = "/android/dish/{id}")
    public
    @ResponseBody
    DishModel getDishById(@PathVariable int id) {
        DishModel dish = menuService.getDish(id);
        return dish;
    }

    // ����� ����� �� ���������
    @RequestMapping(value = "/android/dish/category/{id}")
    @ResponseBody
    public ArrayList<DishModel> getAllDishesByCategory(@PathVariable int id) {
        CategoryModel category = categoryService.get(id);
        ArrayList<DishModel> allDishesByCategory = menuService.getAllDishesForCategory(category);
        return allDishesByCategory;
    }

}