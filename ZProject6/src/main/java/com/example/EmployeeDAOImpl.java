package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAOInterface {
    private String jdbcURL = "jdbc:mysql://localhost:3306/empos";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Satyam@#567";

    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employees (name, email, country) VALUES (?, ?, ?)";
    private static final String SELECT_EMPLOYEE_BY_ID_SQL = "SELECT id, name, email, country FROM employees WHERE id = ?";
    private static final String SELECT_ALL_EMPLOYEES_SQL = "SELECT * FROM employees";
    private static final String UPDATE_EMPLOYEE_SQL = "UPDATE employees SET name = ?, email = ?, country = ? WHERE id = ?";
    private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM employees WHERE id = ?";
    private static final String SEARCH_EMPLOYEES_BY_NAME_SQL = "SELECT * FROM employees WHERE name LIKE ?";

    public EmployeeDAOImpl() {
    }

    protected Connection getConnection() throws SQLException {
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

    @Override
    public void insertEmployee(Employee employee) throws EmployeeDAOException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new EmployeeDAOException("Error inserting employee.", e);
        }
    }

    @Override
    public Employee selectEmployee(int id) throws EmployeeDAOException {
        Employee employee = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                employee = new Employee(id, name, email, country);
            }
        } catch (SQLException e) {
            throw new EmployeeDAOException("Error selecting employee by ID.", e);
        }
        return employee;
    }

    @Override
    public List<Employee> selectAllEmployees() throws EmployeeDAOException {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES_SQL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                employees.add(new Employee(id, name, email, country));
            }
        } catch (SQLException e) {
            throw new EmployeeDAOException("Error selecting all employees.", e);
        }
        return employees;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws EmployeeDAOException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getCountry());
            preparedStatement.setInt(4, employee.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new EmployeeDAOException("Error updating employee.", e);
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteEmployee(int id) throws EmployeeDAOException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new EmployeeDAOException("Error deleting employee.", e);
        }
        return rowDeleted;
    }

    @Override
    public List<Employee> searchEmployeesByName(String name) throws EmployeeDAOException {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_EMPLOYEES_BY_NAME_SQL)) {
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String employeeName = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                employees.add(new Employee(id, employeeName, email, country));
            }
        } catch (SQLException e) {
            throw new EmployeeDAOException("Error searching employees by name.", e);
        }
        return employees;
    }
}
