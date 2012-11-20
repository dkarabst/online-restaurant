package com.softserve.academy.food.service;

import com.softserve.academy.food.dao.CategoryDao;
import com.softserve.academy.food.entity.Category;
import com.softserve.academy.food.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Transactional
    public ArrayList<Category> getAll() {
        ArrayList<Category> models = new ArrayList<Category>();
        for (Category m : categoryDao.getAll()) {
            models.add(m);
        }
        return models;
    }

    @Transactional
    public Category get(int id) {
        if (categoryDao.get(id) != null) {
            return categoryDao.get(id);
        }
        return new Category();
    }


	@Transactional
    public void add(Category category) {
        categoryDao.add(category);
    }

    @Transactional
    public void delete(int id) {
        categoryDao.delete(id);
    }




}