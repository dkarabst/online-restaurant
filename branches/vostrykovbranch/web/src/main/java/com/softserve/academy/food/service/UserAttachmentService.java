package com.softserve.academy.food.service;


import java.util.List;

import com.softserve.academy.food.entity.UserAttachment;


public interface UserAttachmentService {

    void add( UserAttachment attachmentModel );

    List<UserAttachment> getAll();

    UserAttachment setModel(String name, String path);

}
