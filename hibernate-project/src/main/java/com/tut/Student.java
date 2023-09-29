package com.tut;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import com.tut.*;


@Entity 
public class Student {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id ;
	private String Name ;
	private String City ;
	private Certificate Certificate ;
	
	public Certificate getCertificate() {
		return Certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.Certificate = certificate;
	}

	public Student(int Id, String Name ,String City) 
	{
		this.Id = Id ;
		this.Name = Name ;
		this.City = City ;
	}
	
	public Student() 
	{
	}
	
	public void setId(int Id) 
	{
		this.Id = Id ;
	}
	
	public void setName(String Name) 
	{
		this.Name = Name ;
	}
	
	public void setCity(String City) 
	{
		this.City = City ;
	}
	
	public int getId(int Id) 
	{
		return this.Id;
	}
	
	public String getName() 
	{
	    return	this.Name ;
	}
	
	public String getCity() 
	{
		return this.City ;
	}
	
	
}
