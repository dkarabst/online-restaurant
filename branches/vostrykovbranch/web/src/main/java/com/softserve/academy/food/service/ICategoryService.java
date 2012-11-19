package com.softserve.academy.food.service;

import com.softserve.academy.food.model.CategoryModel;

import java.util.ArrayList;

public interface ICategoryService {

    public ArrayList<CategoryModel> getAll();

    public CategoryModel get(int id);

    //TODO delete
    public void add(CategoryModel category);

    //TODO remove
    public void delete(int id);

}
