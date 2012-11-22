package com.softserve.academy.food.dao;

import java.util.List;


public interface ISqlQueryDao {
	
	    public  List<?> doScript(String script);

}
