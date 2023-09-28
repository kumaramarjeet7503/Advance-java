package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args ) throws IOException
    {
    	Configuration cfg = new Configuration() ;
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory = cfg.buildSessionFactory();

        // Creating Student
//    	Student st = new Student() ;
//    	st.setId(1);
//    	st.setName("Amarjeet");
//    	st.setCity("Mohan Garden");
//    	
    	
//    	Saving for address
    	Address address = new Address() ;
    	address.setCity("Johanees berg") ;
    	address.setStreet("Bolika") ;
    	address.setPostalCode(12012) ;
    	address.setBoxNo("3") ;
    	address.setIsActive(true) ;
    	address.setCreatedDate(new Date()) ;
    	
    	FileInputStream fis = new FileInputStream("src/main/java/alert.jpg") ;
    	byte[] data = new byte[fis.available()] ;
    	fis.read(data) ;
    	address.setImage(data) ;
    	
    	Session session = factory.openSession() ;
//    	
    	Transaction tx = session.beginTransaction() ;

    	try 
    	{
//    		session.persist(address);
//        	tx.commit(); 
        	
    	}catch(Exception e) 
    	{
    		e.printStackTrace();
    	}
    	session.close(); 
    	
     }



}
