package com.hello.controller;

import java.util.ArrayList;

import com.hello.service.CatService; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class CatController extends AbstractController {
	
	ArrayList<String> categoryList;
	
	public CatController() {
		CatService service = new CatService();
		this.categoryList = service.getCategoryList();		
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		return new ModelAndView("categoryPage","categories", categoryList);
	}

//	public void setMessage(String message) {
//		CatService service = new CatService();
//		
//		this.categoryList = service.getCategoryList();
//	}
}
