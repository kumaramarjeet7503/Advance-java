package com.tut;
import org.hibernate.*;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class Employee {

	@Id 
	private int EId ;
	private String Name ;
	@ManyToMany
	@JoinTable(name="EmployeeProject",joinColumns = { @JoinColumn(name="Eid") },inverseJoinColumns = {@JoinColumn(name="Pid")})
	private List<Project> projects ;
	
	public  Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getEId() {
		return EId;
	}

	public void setEId(int eId) {
		EId = eId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}
