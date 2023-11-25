package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SaveEmployeeAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Cast the form to your specific RegistrationForm
        RegistrationForm registrationForm = (RegistrationForm) form;

        // Extract data from the form
        String firstName = registrationForm.getFirstName();
        String lastName = registrationForm.getLastName();
        String street = registrationForm.getStreet();
        String city = registrationForm.getCity();
        String state = registrationForm.getState();
        String zipCode = registrationForm.getZipCode();

        // You can perform additional validation and business logic here

        // Save the employee data to the database
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "INSERT INTO employee (first_name, last_name, street, city, state, zip_code) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, street);
                preparedStatement.setString(4, city);
                preparedStatement.setString(5, state);
                preparedStatement.setString(6, zipCode);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    // Data successfully saved, you may forward to a success page
                    return mapping.findForward("success");
                } else {
                    // Data not saved, you may forward to a failure page
                    return mapping.findForward("failure");
                }
            }
        } catch (SQLException e) {
            // Handle database connection or query errors
            e.printStackTrace(); // Log the exception or handle it as needed
            return mapping.findForward("failure");
        }
    }
}
