package com.softserve.academy.food.dao;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softserve.academy.food.entity.Attachment;
import com.softserve.academy.food.entity.User;

@Repository("attachmentDao")
public class AttachmentDao
{
	@Autowired
	private SessionFactory	sessionFactory;

	public Attachment get(int id)
	{
		return (Attachment) sessionFactory.getCurrentSession().get(
				Attachment.class, id);
	}

	public Attachment get(String name)
	{
		return (Attachment) sessionFactory.getCurrentSession()
				.createQuery("from Attachment where name ='" + name + "'")
				.list().get(0);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Attachment> getAll()
	{
		return (ArrayList<Attachment>) sessionFactory.getCurrentSession()
				.createQuery("from Attachment").list();
	}

	public void add(User user, String name, String path, Date modified)
	{
		sessionFactory.getCurrentSession().save(
				new Attachment(user, name, path, modified));
	}

	public void delete(int id)
	{
		String hql = "DELETE FROM ATTACHMENTS WHERE att_id ='" + id + "'";
		sessionFactory.getCurrentSession().createQuery(hql);
	}

	public void delete(String name)
	{
		String hql = "DELETE FROM ATTACHMENTS WHERE name ='" + name + "'";
		sessionFactory.getCurrentSession().createQuery(hql);
	}
}
