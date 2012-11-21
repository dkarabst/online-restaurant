package com.softserve.academy.food.android.model;

import java.util.ArrayList;
import java.util.SortedMap;

public class AndroidMapModel {
	
	private SortedMap<Integer ,CategoryModel> categoryList;
	private SortedMap<Integer ,ArrayList<DishModel>> dishesList;
	
	public SortedMap<Integer, CategoryModel> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(SortedMap<Integer, CategoryModel> categoryList) {
		this.categoryList = categoryList;
	}

	public SortedMap<Integer, ArrayList<DishModel>> getDishesList() {
		return dishesList;
	}
	public void setDishesList(SortedMap<Integer, ArrayList<DishModel>> dishesList) {
		this.dishesList = dishesList;
	}
	

}
