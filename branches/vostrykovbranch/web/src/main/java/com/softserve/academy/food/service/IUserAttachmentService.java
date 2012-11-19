package com.softserve.academy.food.service;


import java.util.List;

import com.softserve.academy.food.model.UserAttachmentModel;

public interface IUserAttachmentService {

    void add( UserAttachmentModel attachmentModel );

    List<UserAttachmentModel> getAll();

    UserAttachmentModel setModel(String name, String path);

}
