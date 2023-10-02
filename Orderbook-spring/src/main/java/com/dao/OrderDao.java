package com.dao;

import java.util.List ;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entities.Order;

@Component
public class OrderDao {

	@Autowired
	HibernateTemplate template ;
	
	@Transactional
	public int save(Order order) 
	{
		Integer i = (Integer) this.template.save(order) ;
		return i ;
	}
	
	public List<Order> getAll()
	{
		List<Order> orders = this.template.loadAll(Order.class) ;
		return orders ;
	}

}
