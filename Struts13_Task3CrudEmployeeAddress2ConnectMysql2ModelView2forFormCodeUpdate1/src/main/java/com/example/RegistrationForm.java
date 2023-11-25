package com.example;

import org.apache.struts.action.ActionForm;

public class RegistrationForm extends ActionForm {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String zipCode;

    // Constructors, getters, and setters

    public RegistrationForm() {
        // Default constructor
    }

    // Getters and setters for each field

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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    // Additional methods as needed
}
