package com.softserve.academy.food.service;

import com.softserve.academy.food.dao.DishDao;
import com.softserve.academy.food.entity.Dish;
import com.softserve.academy.food.model.CategoryModel;
import com.softserve.academy.food.model.DishModel;
import com.softserve.academy.food.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("dishService")
public class MenuServiceImpl implements MenuService {
    @Autowired
    private DishDao dishDao;

    @Transactional
    public ArrayList<DishModel> getAllDishes() {
        ArrayList<DishModel> models = new ArrayList<DishModel>();
        for (Dish m : dishDao.getAll()) {
            models.add(m.toModel());
        }
        return models;
    }

    @Transactional
    public ArrayList<DishModel> getAllDishesForCategory(CategoryModel category) {
        ArrayList<DishModel> models = new ArrayList<DishModel>();
        for (Dish dish : dishDao.getAll(category.toEntity())) {
            models.add(dish.toModel());
        }
        return models;
    }

    @Transactional
    public DishModel getDish(int id) {
        if (dishDao.get(id) != null) {
            return dishDao.get(id).toModel();
        }
        return new DishModel();
    }

}
