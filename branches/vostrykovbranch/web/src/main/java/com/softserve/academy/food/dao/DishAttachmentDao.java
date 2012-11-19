package com.softserve.academy.food.dao;

import com.softserve.academy.food.entity.DishAttachment;

import java.util.List;

public interface DishAttachmentDao {

    void add(DishAttachment dishAttachment);

    List<DishAttachment> getAll();

    DishAttachment get(Long id);

}
