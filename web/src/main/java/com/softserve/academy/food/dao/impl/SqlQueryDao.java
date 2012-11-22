package com.softserve.academy.food.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softserve.academy.food.dao.ISqlQueryDao;

import antlr.collections.List;

@Repository("sqlDao")
public class SqlQueryDao implements ISqlQueryDao{

		@Autowired
		private SessionFactory sessionFactory;

		public java.util.List<?> doScript(String script) {

			Query query = sessionFactory.getCurrentSession().createSQLQuery(
					script);
			List result = (List) query.list();
			return (java.util.List<?>) result;

		}	

}
