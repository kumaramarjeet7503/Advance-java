package com.tut;

import java.util.List;

import org.hibernate.*;

import jakarta.persistence.*;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id ;
	private String Description ;
	
	@OneToMany(mappedBy ="question",fetch=FetchType.EAGER)
	private List<Answer> Answer ;
	
	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public List<Answer> getAnswerId() {
		return Answer;
	}

	public void setAnswerId(List<Answer> answerId) {
		Answer = answerId;
	}

	public Question() {
		// TODO Auto-generated constructor stub
	}

}
