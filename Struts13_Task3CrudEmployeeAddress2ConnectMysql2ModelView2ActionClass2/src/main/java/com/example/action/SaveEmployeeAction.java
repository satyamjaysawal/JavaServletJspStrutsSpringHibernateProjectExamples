package com.example.action;

import com.example.model.Address;
import com.example.model.EmployeeForm;
import com.example.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SaveEmployeeAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        
        try {
            EmployeeForm employeeForm = (EmployeeForm) form;

            String firstName = employeeForm.getFirstName();
            String lastName = employeeForm.getLastName();
            String email = employeeForm.getEmail();
            Address address = employeeForm.getAddress();

            try (Connection connection = DBConnection.getConnection()) {
                String insertSql = "INSERT INTO employee (first_name, last_name, email, city, district) VALUES (?, ?, ?, ?, ?)";

                try (PreparedStatement statement = connection.prepareStatement(insertSql)) {
                    statement.setString(1, firstName);
                    statement.setString(2, lastName);
                    statement.setString(3, email);
                    statement.setString(4, address.getCity());
                    statement.setString(5, address.getDistrict());

                    statement.executeUpdate();
                    System.out.println("Values Inserted in Database");
                }
            }

            List<EmployeeForm> listOfEmployeeForms = getEmployeeFormList();
            request.setAttribute("employeeList", listOfEmployeeForms);
            
            request.setAttribute("name", firstName + " " + lastName);
            request.setAttribute("email", email);
            request.setAttribute("address", address);

            return mapping.findForward("success");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
            return mapping.findForward("failure");
        }
    }

    public List<EmployeeForm> getEmployeeFormList() {
        List<EmployeeForm> listOfEmployeeForms = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection()) {
            String selectSql = "SELECT * FROM employee";

            try (PreparedStatement statement = connection.prepareStatement(selectSql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    EmployeeForm employeeForm = new EmployeeForm();
                    employeeForm.setFirstName(resultSet.getString("first_name"));
                    employeeForm.setLastName(resultSet.getString("last_name"));
                    employeeForm.setEmail(resultSet.getString("email"));

                    Address address = new Address();
                    address.setCity(resultSet.getString("city"));
                    address.setDistrict(resultSet.getString("district"));
                    employeeForm.setAddress(address);

                    listOfEmployeeForms.add(employeeForm);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listOfEmployeeForms;
    }
}
