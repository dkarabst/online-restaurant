package com.softserve.academy.food.service.impl;

import com.softserve.academy.food.dao.IUserAttachmentDao;
import com.softserve.academy.food.entity.UserAttachment;
import com.softserve.academy.food.model.UserAttachmentModel;
import com.softserve.academy.food.service.IUserAttachmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserAttachmentService implements IUserAttachmentService {

    @Autowired
    IUserAttachmentDao attachmentDao;

    @Override
    public UserAttachmentModel setModel(String name, String path) {
        return new UserAttachmentModel(name, path);
    }

    @Override
    public void add(UserAttachmentModel attachmentModel) {
        attachmentDao.add(attachmentModel.toEntity());
    }

    @Override
    public List<UserAttachmentModel> getAll() {
        List<UserAttachmentModel> attachmentModelList = new ArrayList<UserAttachmentModel>();
        for(UserAttachment attachment : attachmentDao.getAll()) {
                attachmentModelList.add(attachment.toModel());
        }
        return attachmentModelList;
    }
}