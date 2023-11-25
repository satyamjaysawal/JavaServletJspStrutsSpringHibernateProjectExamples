package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/Nov22DB";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Satyam@#567";

    // Load the MySQL JDBC driver during class initialization
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading MySQL JDBC driver");
        }
    }

    // Private constructor to prevent instantiation of the class
    private DBConnection() {
    }

    // Get a connection to the database
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error connecting to the database");
        }
    }

    // Close the database connection
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error closing the database connection");
        }
    }
}
