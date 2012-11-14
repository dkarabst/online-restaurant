package com.softserve.academy.food.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.softserve.academy.food.entity.OrderContents;
import com.softserve.academy.food.entity.OrderInfo;

public class OrderModel
{
	private int 				id;
	private UserModel			user;
	private Date				date;
	private Character			status;
	private List<ContentModel>	spec;

	public OrderModel()
	{
	}

	public OrderModel( OrderInfo order )
	{
		id = order.getId();
		user = order.getUser().toModel();
		date = order.getDate();
		status = order.getStatus();
		
		List<ContentModel>	spec = new ArrayList<ContentModel>();
		for (OrderContents content : order.getSpec())
		{
			spec.add(content.toModel());
		}
		this.spec = spec;
	}

	public OrderInfo toEntity()
	{
		return new OrderInfo( this );
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public List<ContentModel> getSpec() {
		return spec;
	}

	public void setSpec(List<ContentModel> spec) {
		this.spec = spec;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + ((spec == null) ? 0 : spec.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof OrderModel))
			return false;
		OrderModel other = (OrderModel) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (spec == null) {
			if (other.spec != null)
				return false;
		} else if (!spec.equals(other.spec))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderModel [id=" + id + ", user=" + user + ", date=" + date
				+ ", status=" + status + ", spec=" + spec + "]";
	}
	
}
