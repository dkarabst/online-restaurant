package com.softserve.academy.food.dao;
//package com.hello.dao;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.*;


public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	
	static {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

    public static Session getSession()
            throws HibernateException {
        return sessionFactory.openSession();
    }
}