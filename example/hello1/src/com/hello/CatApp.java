package com.hello;

import java.util.ArrayList;

import com.hello.service.CatService;

public class CatApp {

	public static void main(String[] arg) {
		CatService service = new CatService();
		ArrayList<String> sList = service.getCategoryList();
		
        System.out.println("���������� ������� \"CATEGORIES\":");
		for (String s : sList) {
			System.out.println(s);
		}
	}
}
