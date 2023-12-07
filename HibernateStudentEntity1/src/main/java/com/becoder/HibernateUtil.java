package com.becoder;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Environment;
import java.util.Properties;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			Properties properties = new Properties();
			properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver"); // corrected driver name for MySQL 8
			properties.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernateDB");
			properties.put(Environment.USER, "root");
			properties.put(Environment.PASS, "Satyam@#567");
			properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
			properties.put(Environment.HBM2DDL_AUTO, "update");
			properties.put(Environment.SHOW_SQL, true);
			configuration.setProperties(properties);
			
			//your entity class // Agar Package different ho to package ka name dena pdta hai
//			 configuration.addAnnotatedClass(com.becoder.model.Student.class); 
			
			// Entity class ke package ka naam set karein
//			 configuration.addPackage("com.becoder");
			
			configuration.addAnnotatedClass(Student.class); 
			
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
}
