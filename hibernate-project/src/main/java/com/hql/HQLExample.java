package com.hql;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Employee;

public class HQLExample {


	public static void main(String[] args) {
		
		Configuration cnf = new Configuration() ;
		cnf.configure("hibernate.cfg.xml");
		SessionFactory factory = cnf.buildSessionFactory() ;
		
		String query = "from Employee where Name = 'kamlesh'" ;
		Session session = factory.openSession() ;
		Query hql =  session.createQuery(query) ;
	 	List<Employee> emp = hql.list() ;
	 	for(Employee e : emp) 
	 	{
	 		System.out.println(e.getName()); 
	 		System.out.println(e.getEId()); 
	 	}
		
	}

}
