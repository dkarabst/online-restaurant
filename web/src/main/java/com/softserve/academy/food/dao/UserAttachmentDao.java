package com.softserve.academy.food.dao;

import com.softserve.academy.food.entity.UserAttachment;

import java.util.List;

public interface UserAttachmentDao {

    void add(UserAttachment userAttachment);

    List<UserAttachment> getAll();

}
