package com.example;

import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
    private String password;

    // Getter and Setter methods for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter methods for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
