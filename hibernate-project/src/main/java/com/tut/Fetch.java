package com.tut;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import com.tut.Address; 


public class Fetch {

	public static void main(String[] args) 
	{
//		Set hibernate configuration
		Configuration cnf = new Configuration() ;
		cnf.configure("hibernate.cfg.xml") ;
//		 Build session factory
		SessionFactory  factory = cnf.buildSessionFactory() ;
//		 Open session 
		Session session = factory.openSession() ;
		Address ad =  session.get(Address.class,1) ;
	    System.out.println(ad.getCity());

	    session.close();
	    
	    Session session1 = factory.openSession() ;
	    Address ad1 =  session1.get(Address.class,1) ;
	    System.out.println(ad1.getCity());
		
	}


}
