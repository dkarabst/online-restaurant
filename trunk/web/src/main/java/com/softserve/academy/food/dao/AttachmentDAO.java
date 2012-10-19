package com.softserve.academy.food.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.softserve.academy.food.entity.Attachment;
import com.softserve.academy.food.entity.User;
import com.softserve.academy.food.model.AttachmentModel;
import com.softserve.academy.food.model.IModel;

public class AttachmentDAO
{
	protected Query		queryResult;
	protected Session	session;

	public IModel getModelById(int id)
	{
		Attachment att = (Attachment) session.get(Attachment.class, id);
		return new AttachmentModel(att.getUser(), att.getName(), att.getPath(),
				att.getModified());
	}

	public IModel getModelByName(String name)
	{
		queryResult = session.createQuery("from ATTACHMENTS where name ="
				+ name);
		session.flush();
		Attachment att = (Attachment) queryResult.list().get(0);
		return new AttachmentModel(att.getUser(), att.getName(), att.getPath(),
				att.getModified());
	}

	public ArrayList<AttachmentModel> getAllModels()
	{
		queryResult = session.createQuery("from ATTACHMENTS");
		session.flush();
		@SuppressWarnings("unchecked")
		List<Attachment> entityList = queryResult.list();
		ArrayList<AttachmentModel> modelList = new ArrayList<AttachmentModel>();
		for (Attachment att : entityList)
		{
			modelList.add(new AttachmentModel(att.getUser(), att.getName(), att
					.getPath(), att.getModified()));
		}
		return modelList;
	}

	public void addModel(User user, String name, String path, Date modified)
	{
		session.save(new Attachment(user,name,path,modified));
		session.flush();
	}

	public void delModelById(int id)
	{
		String hql = "DELETE FROM ATTACHMENTS WHERE att_id =" + id;
		session.createQuery(hql);
	}

	public void delModelByName(String name)
	{
		String hql = "DELETE FROM ATTACHMENTS WHERE name =" + name;
		session.createQuery(hql);
	}
}
