package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.* ;
import com.entities.*;

public class MyListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("Context created...");
		List<Order> orders = new ArrayList<Order>() ;
		ServletContext context = sce.getServletContext() ;
		context.setAttribute("orders",orders);
	}


}
