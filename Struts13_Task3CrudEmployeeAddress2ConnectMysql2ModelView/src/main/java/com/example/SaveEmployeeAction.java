package com.example;

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
            Employee employee = (Employee) form;

            String firstName = employee.getFirstname();
            String lastName = employee.getLastname();
            String email = employee.getEmail();
            Address address = employee.getAddress();

            try (Connection connection = DBConnection.getConnection()) {
                String sql = "INSERT INTO employee (first_name, last_name, email, city, district) VALUES (?, ?, ?, ?, ?)";

                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, firstName);
                    statement.setString(2, lastName);
                    statement.setString(3, email);
                    statement.setString(4, address.getCity());
                    statement.setString(5, address.getDistrict());

                    statement.executeUpdate();
                    System.out.println("Values Inserted in Database");
                }
            }

            List<Employee> listOfEmployees = getEmployeeList();
            request.setAttribute("employeeList", listOfEmployees);
            
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

    public List<Employee> getEmployeeList() {
        List<Employee> listOfEmployees = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT * FROM employee";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Employee employee = new Employee();
                        employee.setFirstname(resultSet.getString("first_name"));
                        employee.setLastname(resultSet.getString("last_name"));
                        employee.setEmail(resultSet.getString("email"));

                        Address address = new Address();
                        address.setCity(resultSet.getString("city"));
                        address.setDistrict(resultSet.getString("district"));
                        employee.setAddress(address);

                        listOfEmployees.add(employee);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listOfEmployees;
    }
}
