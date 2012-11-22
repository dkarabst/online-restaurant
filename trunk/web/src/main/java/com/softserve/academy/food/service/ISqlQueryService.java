package com.softserve.academy.food.service;

import java.util.List;

import net.sf.jsqlparser.JSQLParserException;


public interface ISqlQueryService {
	
	 public List<?> doScript(String script) throws JSQLParserException;
	

}
