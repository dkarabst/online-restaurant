package com.softserve.academy.food.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softserve.academy.food.dao.ISqlQueryDao;

import antlr.collections.List;

@Repository("MocksqlDao")
public class MockSqlQueryDao implements ISqlQueryDao{


		public java.util.List<?> doScript(String script) {

			return null;

		}	

}
