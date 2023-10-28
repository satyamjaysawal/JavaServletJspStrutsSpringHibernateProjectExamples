package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        Employee employee = (Employee) form;
        String firstName = employee.getFirstname();
        String lastName = employee.getLastname();
        String email = employee.getEmail();

    

        // Save data to the database
        saveToDatabase(employee);

        // Set attributes for the success page
        request.setAttribute("firstname", firstName);
        request.setAttribute("lastname", lastName);
        request.setAttribute("email", email);
        

        return mapping.findForward("success");
    }

    private void saveToDatabase(Employee employee) {
        try {
            Connection connection = DBConnectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO employees (firstname, lastname, email, city, district) VALUES (?, ?, ?, ?, ?)");

            preparedStatement.setString(1, employee.getFirstname());
            preparedStatement.setString(2, employee.getLastname());
            preparedStatement.setString(3, employee.getEmail());
          

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
