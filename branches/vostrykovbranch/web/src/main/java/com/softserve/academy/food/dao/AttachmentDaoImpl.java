package com.softserve.academy.food.dao;


import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.softserve.academy.food.entity.Attachment;

@Repository
public class AttachmentDaoImpl extends DaoImpl implements AttachmentDao {

    @Override
    public void add(Attachment attachment) {
        getSession().save(attachment);
    }

    @Override
    public Attachment get(Long id) {
        return (Attachment) getSession().load(Attachment.class, id);
    }

    @SuppressWarnings("unchecked")
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
