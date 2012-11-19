package com.softserve.academy.food.service;

import com.softserve.academy.food.entity.Category;
import com.softserve.academy.food.entity.Dish;


import java.util.ArrayList;

public interface MenuService {

    public ArrayList<Dish> getAllDishes();

    public ArrayList<Dish> getAllDishesForCategory(Category category);

    public Dish getDish(int id);

}
