package com.softserve.academy.food.model;

import com.softserve.academy.food.entity.User;

public class UserCredentials 
{
	private int id;
	private String name;
	private String password;
	private String role = "ROLE_USER";
	private Boolean	enable=true;

	public UserCredentials() {
	}
	
	public UserCredentials(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public UserCredentials(User user) {
		id = user.getId();
		name = user.getName();
		password = user.getPassword();
		role = user.getRole();
		enable = user.getEnable();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enable == null) ? 0 : enable.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof UserCredentials))
			return false;
		UserCredentials other = (UserCredentials) obj;
		if (enable == null) {
			if (other.enable != null)
				return false;
		} else if (!enable.equals(other.enable))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return "UserCredentials [id=" + id + ", name=" + name + ", password="
				+ password + ", role=" + role + ", enable=" + enable + "]";
	}



}
