package com.softserve.academy.food.dao;

import com.softserve.academy.food.dao.CategoryDao;
import com.softserve.academy.food.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("categoryDao")
public class CategoryDaoImpl extends DaoImpl implements CategoryDao {

    //TODO delete?
    public Category add(Category category) {
        category.setId((Integer) sessionFactory.getCurrentSession().save(category));
        return category;
    }

    @SuppressWarnings("unchecked")
	public ArrayList<Category> getAll() {
        return (ArrayList<Category>) sessionFactory.getCurrentSession()
                .createQuery("from Category").list();
    }

    public Category get(int id) {
        return (Category) sessionFactory.getCurrentSession().get(
                Category.class, id);
    }

    //TODO delete
    public void delete(int id) {
        Category object = (Category) sessionFactory.getCurrentSession().load(
                Category.class, id);
        if (null != object) {
            sessionFactory.getCurrentSession().delete(object);
        }
    }

}
