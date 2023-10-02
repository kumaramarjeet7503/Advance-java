package com.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.dao.*;
import com.entities.Order;

@Controller
public class HomeController {

	@Autowired
	private ServletContext context ;
	
	@Autowired
	OrderDao orderDao ;
	
	@RequestMapping("/home")
	public String Home(Model model) 
	{
//		List<Order> contextOrder = (List<Order>)context.getAttribute("orders");
		List<Order> contextOrder = this.orderDao.getAll() ;
		model.addAttribute("orders",contextOrder) ;
		
		String page ="home" ;
		model.addAttribute("page", page) ;
		return "home" ;
	}
	
	@RequestMapping("/add")
	public String Add(Model model) 
	{
		Order order = new Order() ;
		String page ="add" ;
		model.addAttribute("page", page) ;
		model.addAttribute("order",order);
		return "home" ;
	}
	
	@RequestMapping("/view")
	public String View(Model model) 
	{
//		List<Order> contextOrder = (List<Order>)context.getAttribute("orders");
		List<Order> contextOrder = this.orderDao.getAll() ;
		model.addAttribute("orders",contextOrder) ;
		String page ="view" ;
		model.addAttribute("page", page) ;
		return "home" ;
	}
	
	@RequestMapping(value="/save-order",method=RequestMethod.POST)
	public String Save(@ModelAttribute("order") Order o ,Model model) 
	{
		
//		List<Order> contextOrder = (List<Order>)context.getAttribute("orders");
//		contextOrder.add(o) ;
		
		this.orderDao.save(o) ;
		
		model.addAttribute("message","successfully added");
		String page ="home" ;
		model.addAttribute("page", page) ;
		return "home" ;
	}


}
