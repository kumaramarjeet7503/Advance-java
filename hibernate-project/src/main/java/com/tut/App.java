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
    	Student st = new Student() ;
    	st.setId(2);
    	st.setName("Karishma");
    	st.setCity("Bardoli");
//    	Set Certificate with embeddable
    	Certificate certificate = new Certificate() ;
    	certificate.setDuration(2.25);
    	certificate.setCourse("Immigrations");
    	st.setCertificate(certificate);
    	
//    	Saving for address
    	Address address = new Address() ;
    	address.setCity("Babben") ;
    	address.setStreet("Lake City") ;
    	address.setPostalCode(841434) ;
    	address.setBoxNo("3") ;
    	address.setIsActive(true) ;
    	address.setCreatedDate(new Date()) ;
    	address.setStudentId(2);
    	
    	FileInputStream fis = new FileInputStream("src/main/java/alert.jpg") ;
    	byte[] data = new byte[fis.available()] ;
    	fis.read(data) ;
    	address.setImage(data) ;
    	
    	Session session = factory.openSession() ;
//    	
    	Transaction tx = session.beginTransaction() ;

    	try 
    	{
    		session.persist(st) ;
    		session.persist(address);
        	tx.commit(); 
        	
    	}catch(Exception e) 
    	{
    		e.printStackTrace();
    	}
    	session.close(); 
    	
     }



}
