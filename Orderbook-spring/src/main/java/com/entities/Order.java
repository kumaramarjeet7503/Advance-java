package com.entities;

public class Order {

	private String ReferenceNumber ;
	private String Description ;
	private int Amount ;
	
	public Order(String referenceNumber, String description, int amount) {
		super();
		ReferenceNumber = referenceNumber;
		Description = description;
		Amount = amount;
	}

	public String getReferenceNumber() {
		return ReferenceNumber;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.ReferenceNumber+" "+this.Description;
	}

	public void setReferenceNumber(String referenceNumber) {
		ReferenceNumber = referenceNumber;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public Order() {
		

	}

}
