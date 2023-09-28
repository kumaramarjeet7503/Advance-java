package com.tut;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
    {
    	Configuration cfg = new Configuration() ;
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory = cfg.buildSessionFactory();

        // Creating Student
    	Student st = new Student() ;
    	st.setId(1);
    	st.setName("Amarjeet");
    	st.setCity("Mohan Garden");
//    	
    	Session session = factory.openSession() ;
//    	
    	Transaction tx = session.beginTransaction() ;

    	try 
    	{
    		session.persist(st);
        	tx.commit(); 
        	
    	}catch(Exception e) 
    	{
    		e.printStackTrace();
    	}
    	session.close(); 
    	
     }
}
