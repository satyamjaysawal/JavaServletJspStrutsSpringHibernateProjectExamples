package com.example;

import org.apache.struts.action.ActionForm;

public class EmployeeForm extends ActionForm {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstname;
    private String lastname;
    private String email;
    private Address address = new Address();

    // Constructors, getters, and setters

    public EmployeeForm() {
        // Default constructor
    }

    // Getters and setters

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
