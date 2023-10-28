package com.example;

import org.apache.struts.action.ActionForm;

public class RegistrationForm extends ActionForm {

    private static final long serialVersionUID = 1L;
    private String name;
    private String email;
    private String password;

    // Default constructor
    public RegistrationForm() {
        super();
    }

    public RegistrationForm(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	// Getter and setter methods for the form fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public String getPassword() {
		
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
