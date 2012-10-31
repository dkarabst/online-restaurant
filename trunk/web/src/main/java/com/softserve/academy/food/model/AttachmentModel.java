package com.softserve.academy.food.model;

import com.softserve.academy.food.entity.User;
import java.util.Date;

public class AttachmentModel
{
	private User	user;
	private String	name;
	private String	path;
	private Date	modified;

	public AttachmentModel()
	{
	}

	public AttachmentModel(User user, String name, String path, Date modified)
	{
		this.user = user;
		this.name = name;
		this.path = path;
		this.modified = modified;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public Date getModified()
	{
		return modified;
	}

	public void setModified(Date modified)
	{
		this.modified = modified;
	}
}
