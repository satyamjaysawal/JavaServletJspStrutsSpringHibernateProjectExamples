package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (validateUser(username, password)) {
            // Redirect to a success page or perform other actions
            response.sendRedirect("success.jsp");
        } else {
            // Display an error message on the login page
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    // Implement a method to validate user credentials using JDBC
    private boolean validateUser(String username, String password) {
        // JDBC connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3306/employeedb";
        String dbUser = "root";
        String dbPassword = "Satyam@#567";

        // SQL query to check if the username and password are valid
        String sql = "SELECT * FROM employees WHERE username = ? AND password = ?";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

          
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

         
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Check if the query returned any results
            boolean isValidUser = resultSet.next();

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();

            return isValidUser;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle exceptions here (e.g., log them)
            return false; // Authentication failed due to an exception
        }
    }
}
