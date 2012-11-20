package com.softserve.academy.food.service;

import java.util.ArrayList;

import com.softserve.academy.food.model.CategoryModel;
import com.softserve.academy.food.model.DishModel;

public interface IMenuService {

    public ArrayList<DishModel> getAllDishes();

    public ArrayList<DishModel> getAllDishesForCategory(CategoryModel category);

    public DishModel getDish(int id);

}
