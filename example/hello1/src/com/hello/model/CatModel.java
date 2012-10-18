package com.hello.model;

public class CatModel {
	private String catName;
	
	public CatModel(String name) {
		this.catName = name;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	@Override
	public String toString() {
		return catName;
	}	
}
