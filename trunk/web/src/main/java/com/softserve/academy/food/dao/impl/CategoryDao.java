package com.softserve.academy.food.dao.impl;

import com.softserve.academy.food.dao.ICategoryDao;
import com.softserve.academy.food.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("categoryDao")
public class CategoryDao extends Dao implements ICategoryDao {

    //TODO delete?
    public Category add(Category category) {
        category.setId((Integer) getSession().save(category));
        return category;
    }

    public ArrayList<Category> getAll() {
        return (ArrayList<Category>) getSession()
                .createQuery("from Category").list();
    }

    public Category get(int id) {
        return (Category) getSession().get(
                Category.class, id);
    }

    //TODO delete
    public void delete(int id) {
        Category object = (Category) getSession().load(
                Category.class, id);
        if (null != object) {
            getSession().delete(object);
        }
    }

}
