package com.softserve.academy.food.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.softserve.academy.food.model.OrderModel;

@Entity
@Table(name = "ORDERINFO")
public class OrderInfo
{
	@Id
	@Column(name = "OINFO_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long				id;

	@Column(name = "OINFO_USER_ID")
	private User				user;

	@Temporal(TemporalType.DATE)
	@Column(name = "OINFO_DATE")
	private Date				date;

	@Column(name = "OINFO_STATUS")
	private Character			status;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "OrderInfo")
	private List<OrderContents>	spec	= new ArrayList<OrderContents>();

	public OrderInfo()
	{
	}

	public OrderInfo(User user, Date date, Character status,
			List<OrderContents> spec)
	{
		setUser(user);
		setDate(date);
		setStatus(status);
		setSpec(spec);
	}

	public OrderModel toModel()
	{
		return new OrderModel(user, date, status, spec);
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
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

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public Character getStatus()
	{
		return status;
	}

	public void setStatus(Character status)
	{
		this.status = status;
	}

	public List<OrderContents> getSpec()
	{
		return spec;
	}

	public void setSpec(List<OrderContents> spec)
	{
		this.spec = spec;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		OrderInfo other = (OrderInfo) obj;
		if (date == null)
		{
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (status == null)
		{
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (user == null)
		{
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

} // OrderInfo