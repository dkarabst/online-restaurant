/*
 * 17.10.2012 13:58:23 
 */

package com.softserve.academy.food.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.softserve.academy.food.model.UserCredentials;
import com.softserve.academy.food.model.UserModel;

@Entity
@Table(name = "USERS")
public class User extends AbstractEntity {
	
	private static final long	serialVersionUID	= 1L;

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int				id;
	
	@Column(name = "USER_PASSWORD", length = 50)
	private String password;
	
	@Column(name = "USER_ROLE", length = 50)
	private String role;

	@Column(name = "USER_NAME", length = 50)
	private String				name;

	@Column(name = "USER_EMAIL", length = 50)
	private String				email;

	@Column(name = "USER_PHONE", length = 50)
	private String				phone;

	public User(){
	}

	public User(String name, String email, String phone) {
		setName(name);
		setEmail(email);
		setPhone(phone);
	}
	
	public User(UserModel user) {	
		
		id = user.getId();
		name = user.getName();
		email = user.getEmail();
		phone = user.getPhone();
	}
	
	public User(UserCredentials user) {	
		
		id = user.getId();
		name = user.getName();
		email = user.getPassword();
		phone = user.getRole();
	}
	
	public UserModel toModel()
	{
		return new UserModel(id,name,email,phone);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
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
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", role=" + role
				+ ", name=" + name + ", email=" + email + ", phone=" + phone
				+ "]";
	}
	

} 