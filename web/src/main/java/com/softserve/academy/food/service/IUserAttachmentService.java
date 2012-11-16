package com.softserve.academy.food.service;

import com.softserve.academy.food.model.AttachmentModel;
import com.softserve.academy.food.model.UserAttachmentModel;

import java.util.List;

public interface IUserAttachmentService {

    void add(UserAttachmentModel attachmentModel);

    List<UserAttachmentModel> getAll();

    UserAttachmentModel setModel(String name, String path);

}
