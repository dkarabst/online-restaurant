package com.softserve.academy.food.dao;

import com.softserve.academy.food.entity.Category;
import com.softserve.academy.food.entity.Dish;

import java.util.List;

public interface DishDao extends Dao {

    public Dish get(int id);

    public List<Dish> getAll(Category category);

    public List<Dish> getAll();

    public Dish add(Dish dish);

    public void delete(int id);

}
