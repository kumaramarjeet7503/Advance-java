package com.tut;

import java.util.Date;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity 
@Table(name="address")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Address {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "Id")
	private int Id ;
	
	@Column (name="City",length=50)
	private String City ;
	@Column (name="StreetName",length=50)
	private String Street ;
	@Transient
	private double Price ;
	private int PostalCode ;
	private String BoxNo ;
	private boolean IsActive ;
	
	@Temporal(TemporalType.DATE) 
	private Date CreatedDate ;
	
	@Lob 
	private byte[] Image ;
	private int StudentId ;
	
	
	public int getStudentId() {
		return StudentId;
	}

	public void setStudentId(int studentId) {
		StudentId = studentId;
	}

	public Address() {
		
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public int getPostalCode() {
		return PostalCode;
	}

	public void setPostalCode(int postalCode) {
		PostalCode = postalCode;
	}

	public String getBoxNo() {
		return BoxNo;
	}

	public void setBoxNo(String boxNo) {
		BoxNo = boxNo;
	}

	public boolean isIsActive() {
		return IsActive;
	}

	public void setIsActive(boolean isActive) {
		IsActive = isActive;
	}

	public Date getCreatedDate() {
		return CreatedDate;
	}

	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}

	public byte[] getImage() {
		return Image;
	}

	public void setImage(byte[] image) {
		this.Image = image;
	}
	
	

}
