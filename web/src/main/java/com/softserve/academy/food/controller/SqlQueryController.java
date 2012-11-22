package com.softserve.academy.food.controller;

import java.util.Map;

import net.sf.jsqlparser.JSQLParserException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.softserve.academy.food.service.impl.SqlQueryService;

@Controller
public class SqlQueryController {
	 @Autowired
	    private SqlQueryService sqlService;
	    
	    
	    @RequestMapping("/sql")
	    public String script() {
	        return "doscript";
	    }
	    
	    @RequestMapping(value = "/do", method = RequestMethod.POST)
	    public String doScript(@RequestParam("script")  String script) throws JSQLParserException {
	    	sqlService.doScript(script);

	        return "doscript";
	    }
	    
	    
	}