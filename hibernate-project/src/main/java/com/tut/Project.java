package com.tut;

import org.hibernate.*;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class Project {

	@Id
	private int PId ;
	private String Name ;
	@ManyToMany(mappedBy="projects")
	private List<Employee> employees ; 
	
	public int getPId() {
		return PId;
	}

	public void setPId(int pId) {
		PId = pId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Project() {
		// TODO Auto-generated constructor stub
	}

}
