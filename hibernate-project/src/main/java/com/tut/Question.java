package com.tut;

import org.hibernate.*;

import jakarta.persistence.*;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id ;
	private String Description ;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "AnswerId")
	private Answer Answer ;
	
	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Answer getAnswerId() {
		return Answer;
	}

	public void setAnswerId(Answer answerId) {
		Answer = answerId;
	}

	public Question() {
		// TODO Auto-generated constructor stub
	}

}
