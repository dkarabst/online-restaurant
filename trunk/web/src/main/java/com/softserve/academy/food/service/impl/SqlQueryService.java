package com.softserve.academy.food.service.impl;

import java.io.StringReader;
import java.util.List;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.schema.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.academy.food.dao.ISqlQueryDao;
import com.softserve.academy.food.service.ISqlQueryService;


@Service("sqlService")
public class SqlQueryService implements ISqlQueryService {
	
   @Autowired  
   private ISqlQueryDao sqlDao;
	CCJSqlParserManager parserManager = new CCJSqlParserManager();
	
	 @Transactional
		public List<?> doScript(String script) throws JSQLParserException {
		 
		  PlainSelect select =  (PlainSelect) ((Select) parserManager.parse(new StringReader(script))).getSelectBody();

		 String str = ((Table)(select.getFromItem())).getName();
		 System.out.println(str);
		 
	    	 return sqlDao.doScript(script) ;
			
		}

}
