package com.hello.dao;

import java.util.List;
import java.util.ArrayList;

import com.hello.entity.*;
import com.hello.model.*;

import org.hibernate.Query;
import org.hibernate.Session;


public class CatDAO {
	
	private Query queryResult;
	
	public CatDAO() {
        Session session = HibernateUtil.getSession();  

        session.beginTransaction();        
        queryResult = session.createQuery("from CatEntity");
        session.flush();
//        session.close(); //if uncomment, an error occurs. why???
	}

	public ArrayList<CatModel> getModel() {
        @SuppressWarnings("unchecked")
		List<CatEntity> entityList = queryResult.list();
        CatModel model = null;
        ArrayList<CatModel> modelList = new ArrayList<CatModel>();
        for (CatEntity entity : entityList) {
        	model = new CatModel(entity.getCatName());
        	modelList.add(model);
        }
        return modelList;
	}
}
