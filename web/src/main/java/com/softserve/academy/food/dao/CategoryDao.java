package com.softserve.academy.food.dao;

import com.softserve.academy.food.entity.Category;

import java.util.List;

public interface CategoryDao {

    //TODO delete
    public Category add(Category category);

    public List<Category> getAll();

    //TODO remove
    public void delete(int id);

    public Category get(int id);

}
