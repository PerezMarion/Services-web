package com.mycompany.jakartademo.business;

public class Customer {
	
    private Long id;
    private String firstName;
    private String lastName;
	
    public Customer() {
    }
	
    public Customer(String firstName, String lastName) {
	this.firstName = firstName;
	this.lastName = lastName;
    }
	
    public Long getId() {
		return id;
	}
	
    public void setId(Long id) {
		this.id = id;
	}
	
    public String getFirstName() {
		return firstName;
	}
	
    public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
    public String getLastName() {
		return lastName;
	}
	
    public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
    @Override
    public String toString() {
	return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}