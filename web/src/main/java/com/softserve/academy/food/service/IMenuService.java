package com.softserve.academy.food.service;

import com.softserve.academy.food.dao.IDishDao;
import com.softserve.academy.food.model.CategoryModel;
import com.softserve.academy.food.model.DishModel;

import java.util.ArrayList;

public interface IMenuService {

    public ArrayList<DishModel> getAllDishes();

    public ArrayList<DishModel> getAllDishesForCategory(CategoryModel category);

    public DishModel getDish(int id);

}
