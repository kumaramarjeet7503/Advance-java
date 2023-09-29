package com.tut;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Mapping {

	public Mapping() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Configuration cnf = new Configuration() ;
		cnf.configure("hibernate.cfg.xml") ;
		SessionFactory factory = cnf.buildSessionFactory() ;
		Session session = factory.openSession() ;
		
//		 Set Question
		Question q1 = new Question() ;
		q1.setDescription("What is Marraige ?");
	
		
		Answer ans = new Answer() ;
		ans.setDescription("Marraige is when two person tie know with both.");
		q1.setAnswerId(ans);
		Transaction transaction = session.beginTransaction() ;
		
		try 
		{
			session.persist(q1);
			transaction.commit();
		}catch(Exception e) 
		{
			e.printStackTrace();
			transaction.rollback();
		}finally 
		{
			factory.close();
			session.close();
		}
		
		

	}

}
