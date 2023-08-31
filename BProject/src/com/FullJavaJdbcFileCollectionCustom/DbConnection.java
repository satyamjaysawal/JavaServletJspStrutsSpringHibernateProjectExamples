package com.FullJavaJdbcFileCollectionCustom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Satyam@#567";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Database connected successfully.");
        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            throw e;  // Re-throw the exception to handle it at a higher level if needed
        }
        return connection;
    }
}
