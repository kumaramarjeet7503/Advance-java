package com.tut;

import jakarta.persistence.Embeddable;

@Embeddable 
public class Certificate {

	private String Course ;
	private Double Duration ;
	
	public Certificate() {
		
	}

	public String getCourse() {
		return Course;
	}

	public void setCourse(String course) {
		Course = course;
	}

	public Double getDuration() {
		return Duration;
	}

	public void setDuration(Double duration) {
		Duration = duration;
	}
	
	

}
