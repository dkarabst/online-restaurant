package com.softserve.academy.food.dao;

import com.softserve.academy.food.entity.Attachment;

import java.util.List;

public interface AttachmentDao {

    void add(Attachment attachment);

    Attachment get(Long id);

    List<Attachment> getAll();

    void delete(Long id);

    void delete(Attachment attachment);

}
