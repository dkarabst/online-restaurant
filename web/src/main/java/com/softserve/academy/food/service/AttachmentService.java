package com.softserve.academy.food.service;

import com.softserve.academy.food.model.AttachmentModel;

import java.util.List;

public interface AttachmentService {

    void add(AttachmentModel attachmentModel);

    AttachmentModel get(Long id);

    List<AttachmentModel> getAll();

    void delete(Long id);

    void delete(AttachmentModel attachmentModel);

    AttachmentModel setModel(String name, String path);

}
