package com.hello.service;

import java.util.ArrayList;

import com.hello.dao.CatDAO;
import com.hello.model.CatModel;

public class CatService {
	public ArrayList<String> getCategoryList() {
		CatDAO catDAO = new CatDAO();
		ArrayList<CatModel> mList = catDAO.getModel();
		mList.remove(0); //remove category "Вне категории"
		ArrayList<String> sList = new ArrayList<String>();
		for (CatModel m : mList) {
			sList.add(m.getCatName());
		}
		return sList;
	}
}
