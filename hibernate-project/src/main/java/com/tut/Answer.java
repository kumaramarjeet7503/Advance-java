package com.tut;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)


	private int AnswerId ;
	private String Description ;
	
	@ManyToOne
	private Question question ;
	
	
	public Question getQuestion() {
		return question;
	}


	public void setQuestion(Question question) {
		this.question = question;
	}


	public int getId() {
		return AnswerId;
	}


	public void setId(int id) {
		AnswerId = id;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public Answer() {
		// TODO Auto-generated constructor stub
	}

}
