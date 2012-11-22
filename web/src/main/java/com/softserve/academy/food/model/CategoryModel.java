package com.softserve.academy.food.model;

import java.io.Serializable;

import com.softserve.academy.food.entity.Category;

public class CategoryModel implements Serializable {
    private int id;
    private String name;

    public CategoryModel() {
    }

    public CategoryModel(String name) {
        this.name = name;
    }

    public CategoryModel(Category category) {
        id = category.getId();
        name = category.getName();
    }

    public Category toEntity() {
        return new Category(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof CategoryModel))
            return false;
        CategoryModel other = (CategoryModel) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CategoryModel [id=" + id + ", name=" + name + "]";
    }


}