package com.example.model;

import org.apache.struts.action.ActionForm;

public class EmployeeForm extends ActionForm {
    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private String email;
    private Address address = new Address();

    // Constructors, getters, and setters

    public EmployeeForm() {
        // Default constructor
    }

    // Getters and setters

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
