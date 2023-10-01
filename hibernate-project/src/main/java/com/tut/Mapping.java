package com.tut;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
//import org.hibernate.cache.ehcache.internal.EhcacheRegionFactory ;


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
		q1.setDescription("What is Bowl ?");
	
		
		Answer ans = new Answer() ;
		ans.setDescription("Bowl in which fish lives.");
		ans.setQuestion(q1);
		
		Answer ans2 = new Answer() ;
		ans2.setDescription("It is used for storing water.");
		ans2.setQuestion(q1);
	
		Answer ans3 = new Answer() ;
		ans3.setDescription("It can be used for showcase also .");
		ans3.setQuestion(q1);
		
		List<Answer> answers = new ArrayList() ;
		answers.add(ans);
		answers.add(ans2);
		answers.add(ans3);
		q1.setAnswerId(answers);
		
		// Fetch Data from table
		Question ques = session.get(Question.class,1) ;
		System.out.println(ques);
		
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
