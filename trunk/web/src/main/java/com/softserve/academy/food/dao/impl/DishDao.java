package com.softserve.academy.food.dao.impl;

import com.softserve.academy.food.dao.IDishDao;
import com.softserve.academy.food.entity.Category;
import com.softserve.academy.food.entity.Dish;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("dishDao")
public class DishDao extends Dao implements IDishDao {
    public Dish get(int id) {
        return (Dish) getSession().get(Dish.class, id);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Dish> getAll() {
        return (ArrayList<Dish>) getSession()
                .createQuery("from Dish").list();
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Dish> getAll(Category category) {
        return (ArrayList<Dish>) getSession()
                .createQuery("from Dish where CATEGORIES_cat_id = " + category.getId()).list();
    }

    public Dish add(Dish dish) {
        dish.setId((Integer) getSession().save(dish));
        return dish;
    }

    public void delete(int id) {
        Dish object = (Dish) getSession().load(
                Dish.class, id);
        if (null != object) {
            getSession().delete(object);
        }
    }


}
