package com.softserve.academy.food.xml;



public class CategorySimple {
	 Integer id;
	 String name;
	public CategorySimple() {
	}
	public CategorySimple(Integer id, String name) {
		setId(id);
		setName(name);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


} // CategorySimple