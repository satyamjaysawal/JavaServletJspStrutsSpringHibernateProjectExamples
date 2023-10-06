package com.example.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfigDAO {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/empos";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "Satyam@#567";

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("JDBC driver not found.", e);
        }
        return connection;
    }
}
