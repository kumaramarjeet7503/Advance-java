package com.tut;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class Many {

	public Many() {
		// TODO Auto-generated constructor stub
	}

	private static void main(String[] args) {
		
		Configuration cnf = new Configuration() ;
		cnf.configure("hibernate.cfg.xml");
		SessionFactory factory = cnf.buildSessionFactory() ;
		Session session = factory.openSession() ;
		Transaction trans = session.beginTransaction() ;
		
		try {
		
			Employee e1 = new Employee() ;
			Employee e2 = new Employee() ;
			Project p1 = new Project() ;
			Project p2 = new Project() ;
			Employee e3 = new Employee() ;
			Project p3 = new Project() ;
			
			e3.setEId(1);
			e3.setName("Raging");
			
			e3.setEId(3);
			e3.setName("Kamlesh");
	
			e2.setEId(2);
			e2.setName("Roshni");
			
			p3.setPId(3);
			p3.setName("Go Dart");
//	
			p2.setPId(2);
			p2.setName("Python");
			p1.setPId(1);
			p1.setName("Java");
//			
			List emp = new ArrayList();
			emp.add(e3);
			
			List project = new ArrayList() ;
			project.add(p1) ;
			project.add(p2) ;
			project.add(p3) ;
			
			
			e3.setProjects(project) ;
			p3.setEmployees(emp);
			
			session.persist(e3);
			session.persist(p3);
			trans.commit();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			trans.rollback();
			
		}finally 
		{
			session.close();
		}
		

	}

}
