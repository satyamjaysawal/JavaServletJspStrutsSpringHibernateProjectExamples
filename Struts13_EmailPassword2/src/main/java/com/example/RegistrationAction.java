package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        RegistrationForm registrationForm = (RegistrationForm) form;

        String name = registrationForm.getName();
        String email = registrationForm.getEmail();
        String password = registrationForm.getPassword();

        if (isCredentialsValid(email, password)) {
            System.out.println("User Match in Database");
            // Fetch all user data from the database
            List<String> userData = getUserDataFromDatabase();

            // Set user data as attributes in the request
            request.setAttribute("userData", userData);
            request.setAttribute("email", email);
            request.setAttribute("password", password);
            request.setAttribute("name", name);
            return mapping.findForward("success");
        } else {
            String errorMessage = "The email and password you entered do not match.";
            System.out.println("Error: " + errorMessage);
            request.setAttribute("errorMessage", errorMessage);
            return mapping.findForward("error");
        }
    }

    private List<String> getUserDataFromDatabase() {
        List<String> userData = new ArrayList<>();

        try (Connection connection = DBConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT name, password FROM urs")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Retrieve data from the result set
                    String name = resultSet.getString("name");
                    String password = resultSet.getString("password");
                    userData.add("Name: " + name + ", Password: " + password);
                }
            }
        } catch (SQLException e) {
            // Logging can be added here
            e.printStackTrace();
        }

        return userData;
    }

    private boolean isCredentialsValid(String email, String password) {
        try (Connection connection = DBConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM urs WHERE email=? AND password=?")) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            // Logging can be added here
            e.printStackTrace();
            return false;
        }
    }
}
