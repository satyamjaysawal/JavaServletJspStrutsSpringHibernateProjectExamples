package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.util.List;



public class LoginAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        LoginForm loginForm = (LoginForm) form;

        String email = loginForm.getEmail(); // Get the entered email from the form
        String password = loginForm.getPassword(); // Get the entered password from the form

        // Replace with your own authentication logic
        if (isValidUser(email, password)) {
            List<Employee> employees = EmployeeDataAccess.getAllEmployees(); // Retrieve all employees
            request.setAttribute("employees", employees); // Set the list of employees as a request attribute
        	System.out.println("User Data Match from Database So User Logined");
            return mapping.findForward("success"); // Forward to the employee data page
        } else {
            request.setAttribute("errorMessage", "Invalid credentials. Please try again.");
            return mapping.findForward("error"); // Forward back to the login page with an error message
        }
    }

    // Replace with your own authentication logic
    private boolean isValidUser(String email, String password) {
        // Example hardcoded user validation (Replace with database validation logic)
        return email.equals("e@exam.com") && password.equals("pass123");
    }
}
