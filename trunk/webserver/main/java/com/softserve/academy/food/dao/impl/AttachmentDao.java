package com.softserve.academy.food.dao.impl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softserve.academy.food.dao.IAttachmentDao;
import com.softserve.academy.food.entity.Attachment;
import com.softserve.academy.food.entity.User;

@Repository("attachmentDao")
public class AttachmentDao implements IAttachmentDao
{
	@Autowired
	private SessionFactory	sessionFactory;

	public Attachment get(int id)
	{
		return (Attachment) sessionFactory.getCurrentSession().get(
				Attachment.class, id);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Attachment> get(User user)
	{
		return (ArrayList<Attachment>) sessionFactory.getCurrentSession()
				.createQuery("from Attachment where USERS_user_id="+user.getId()).list();
	}

	public void add( Attachment attachment)
	{
		sessionFactory.getCurrentSession().save( attachment );
	}

	public void delete(int id)
	{
		String hql = "DELETE FROM ATTACHMENTS WHERE att_id ='" + id + "'";
		sessionFactory.getCurrentSession().createQuery(hql);
	}

}
