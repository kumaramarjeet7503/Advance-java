package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.tut.Answer;
import com.tut.Employee;

public class HQLExample {


	public static void main(String[] args) {
		
		Configuration cnf = new Configuration() ;
		cnf.configure("hibernate.cfg.xml");
		SessionFactory factory = cnf.buildSessionFactory() ;
		Session session = factory.openSession() ;
		Transaction t = session.beginTransaction() ;
		String query = "from Employee where Name = 'kamlesh'" ;
		String delQuery = "delete from Employee where Name = 'kamlesh'" ;
		String updateQuery = "update Employee set Name = 'Alia' where Id=: id" ;
		String joinQuery = "select q.Description, a.Description from Question q inner join Answer a " ;
		String sqlQuery = "select * from answer" ;
		
		Query hql =  session.createQuery(joinQuery) ;
		hql.setParameter("id", 1) ;
		
//		Create query 
	 	List<Employee> emp = hql.list() ;
	 	for(Employee e : emp) 
	 	{
	 		System.out.println(e.getName()); 
	 		System.out.println(e.getEId()); 
	 	}
		
//		Delete and update query
		int deletedItem =  hql.executeUpdate() ;
		System.out.println(deletedItem);
		
//		 Join query result
		List<Object[]> questions = hql.getResultList() ;
		for(Object[] arr : questions) {
			System.out.println(Arrays.toString(arr));
		}
		
//		Get data via sql query
		NativeQuery<Answer> nq = session.createNativeQuery(sqlQuery, Answer.class);
		List<Answer> nqAnswers =  nq.list() ;
		
		for(Answer ans : nqAnswers) 
		{
			System.out.println(ans.getDescription());
		}
		
		t.commit();
		
	}

}
