package com.softserve.academy.food.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ATTACHMENTS")
public class Attachment extends AbsEntity
{
	private static final long	serialVersionUID	= 1L;

	@Id
	@Column(name = "att_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer				id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private User				user;

	@Column(name = "name", length = 50)
	private String				name;

	@Column(name = "path", length = 255)
	private String				path;

	@Column(name = "modified")
	private Date				modified;

	public Attachment()
	{
	}

	public Attachment(User user, String name, String path,
			Date modified)
	{
		setUser(user);
		setName(name);
		setPath(path);
		setModified(modified);
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result
				+ ((modified == null) ? 0 : modified.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attachment other = (Attachment) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (user == null)
		{
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (path == null)
		{
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (modified == null)
		{
			if (other.modified != null)
				return false;
		} else if (!modified.equals(other.modified))
			return false;
		return true;
	}

}
