package com.becoder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello ! Satyam Welcome in Hibernates");

		//--------------- XML BASED Configurations --------------------------
		
//        Configuration cfg =new Configuration();
////        cfg.configure("hibernate.cfg.xml");
//        cfg.configure();
//        
//       SessionFactory factory=cfg.buildSessionFactory();
//        System.out.println(factory);

		
		// ek hi line me code likha ..............
//		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//		System.out.println("ek hi line me configuration code likha hai ....\n" + factory);
		
		// ------------------------------XML ------------------------------
		
		//------------------------ CLASS BASED Configuration(HibernateUtil.java) ----------------------
		SessionFactory factory=HibernateUtil.getSessionFactory();
//		System.out.println("HibernateUtil Class Based Configuration \n"+ factory);
		
		Student st=new Student();
		st.setId(1);
		st.setName("Becoder");
		st.setEmail("becode123@gmail.com");
		st.setAddress("India");
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(st);
		tx.commit();
		session.close();
	}
}
