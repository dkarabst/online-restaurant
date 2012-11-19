package com.softserve.academy.food.dao.impl;


import com.softserve.academy.food.dao.IAttachmentDao;
import com.softserve.academy.food.entity.Attachment;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AttachmentDao extends Dao implements IAttachmentDao {

    @Override
    public void add(Attachment attachment) {
        getSession().save(attachment);
    }

    @Override
    public Attachment get(Long id) {
        return (Attachment) getSession().load(Attachment.class, id);
    }

    @Override
    public List<Attachment> getAll() {
        return getSession().createQuery("from Attachment").list();
    }

    @Override
    public void delete(Long id) {
        Query query = getSession().createQuery("delete Attachment where id = :attachmentId");
        query.setLong("attachmentId", id);
        query.executeUpdate();
    }

    @Override
    public void delete(Attachment attachment) {
        getSession().delete(attachment);
    }
}
