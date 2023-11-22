package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
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
            Class.forName("com.mysql.cj.jdbc.Driver");

            Employee employee = (Employee) form;

            String firstName = employee.getFirstname();
            String lastName = employee.getLastname();
            String email = employee.getEmail();
            Address address = employee.getAddress();

            String jdbcUrl = "jdbc:mysql://localhost:3306/Nov22DB";
            String dbUser = "root";
            String dbPassword = "Satyam@#567";

            try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
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
            // Log the exception using a logging framework
            e.printStackTrace();

            request.setAttribute("error", e.getMessage());
            return mapping.findForward("failure");
        }
    }

    public List<Employee> getEmployeeList() {
        List<Employee> listOfEmployees = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String jdbcUrl = "jdbc:mysql://localhost:3306/Nov22DB";
            String dbUser = "root";
            String dbPassword = "Satyam@#567";

            try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
                String sql = "SELECT * FROM employee";

                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    try (ResultSet resultSet = statement.executeQuery()) {
                        while (resultSet.next()) {
                            Employee employee = new Employee();
                            employee.setFirstname(resultSet.getString("first_name"));
                            employee.setLastname(resultSet.getString("last_name"));
                            employee.setEmail(resultSet.getString("email"));

                            // Retrieve address details
                            Address address = new Address();
                            address.setCity(resultSet.getString("city"));
                            address.setDistrict(resultSet.getString("district"));
                            employee.setAddress(address);

                            listOfEmployees.add(employee);
                        }
                    }
                }
            }
        } catch (Exception e) {
            // Log the exception using a logging framework
            e.printStackTrace();
        }

        return listOfEmployees;
    }
}
