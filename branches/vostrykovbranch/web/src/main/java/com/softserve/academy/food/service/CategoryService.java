package com.softserve.academy.food.service;



import java.util.ArrayList;

import com.softserve.academy.food.entity.Category;

public interface CategoryService {

    public ArrayList<Category> getAll();

    public Category get(int id);

    //TODO delete
    public void add(Category category);

    //TODO remove
    public void delete(int id);

}
