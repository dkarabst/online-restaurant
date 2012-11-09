package com.softserve.academy.service;

import com.softserve.academy.dao.AttachmentDao;
import com.softserve.academy.entity.Attachment;
import com.softserve.academy.model.AttachmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    AttachmentDao attachmentDao;

    @Override
    public AttachmentModel setModel(String name, String path) {
        AttachmentModel attachmentModel = new AttachmentModel();
        attachmentModel.setName(name);
        attachmentModel.setPath(path);
        return attachmentModel;
    }

    @Override
    public void add(AttachmentModel attachmentModel) {
        attachmentDao.add(attachmentModel.toEntity());
    }

    @Override
    public AttachmentModel get(Long id) {
        return attachmentDao.get(id).toModel();
    }

    @Override
    public List<AttachmentModel> getAll() {
        List<AttachmentModel> attachmentModelList = new ArrayList<>();
        for(Attachment attachment : attachmentDao.getAll()) {
                attachmentModelList.add(attachment.toModel());
        }
        return attachmentModelList;
    }

    @Override
    public void delete(Long id) {
        attachmentDao.delete(id);
    }

    @Override
    public void delete(AttachmentModel attachmentModel) {
        attachmentDao.delete(attachmentModel.toEntity());
    }

}