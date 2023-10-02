package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entities.Order;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String Home(Model model) 
	{
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
		String page ="view" ;
		model.addAttribute("page", page) ;
		return "home" ;
	}
	
	@RequestMapping(value="/save-order",method=RequestMethod.POST)
	public String Save(@ModelAttribute("order") Order o ,Model model) 
	{
		System.out.println(o);
		String page ="view" ;
		model.addAttribute("page", page) ;
		return "home" ;
	}


}
