package com.tut;

import java.util.ArrayList;
import java.util.List;

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
		q1.setDescription("What is Java ?");
	
		
		Answer ans = new Answer() ;
		ans.setDescription("Java is a programming language.");
		ans.setQuestion(q1);
		
		Answer ans2 = new Answer() ;
		ans2.setDescription("It is the static language.");
		ans2.setQuestion(q1);
	
		Answer ans3 = new Answer() ;
		ans3.setDescription("It can be used by spring hibernate .");
		ans3.setQuestion(q1);
		
		List<Answer> answers = new ArrayList() ;
		answers.add(ans);
		answers.add(ans2);
		answers.add(ans3);
		q1.setAnswerId(answers);
		
		Transaction transaction = session.beginTransaction() ;
		
		try 
		{
			session.persist(q1);
			session.persist(ans);
			session.persist(ans2);
			session.persist(ans3);
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
