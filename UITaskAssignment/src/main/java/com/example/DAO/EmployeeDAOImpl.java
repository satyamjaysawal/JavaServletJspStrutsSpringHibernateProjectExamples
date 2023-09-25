package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.Address;
import com.example.Employee;

public class EmployeeDAOImpl implements EmployeeDAOInterface {
   
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employees (firstname, lastname, email, country, gender, " + "streetAddress, apartment, city, state, postalCode, landmark, phoneNumber, departmentId, jobTitle, salary, workLocation) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_EMPLOYEE_BY_ID_SQL = "SELECT * FROM employees WHERE id = ?";
    private static final String SELECT_ALL_EMPLOYEES_SQL = "SELECT * FROM employees";
    private static final String UPDATE_EMPLOYEE_SQL = "UPDATE employees SET firstname=?, lastname=?, email = ?, country = ?, gender = ?, streetAddress = ?, apartment = ?, city = ?, state = ?, postalCode = ?, landmark = ?, phoneNumber = ?, departmentId = ?, jobTitle = ?, salary = ?, workLocation = ? WHERE id = ?";
    private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM employees WHERE id = ?";
    private static final String SEARCH_EMPLOYEES_BY_ID_OR_NAME_SQL = "SELECT id, firstname, lastname, email, country FROM employees WHERE id = ? OR firstname LIKE ? OR lastname LIKE ?";
   
    public EmployeeDAOImpl() {
    }

    @Override
    public void insertEmployee(Employee employee) throws EmployeeDAOException {
        try (Connection connection = DatabaseConfigDAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            
            preparedStatement.setString(1, employee.getFirstname());
            preparedStatement.setString(2, employee.getLastname());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getCountry());
            preparedStatement.setString(5, employee.getGender());
            
            // Set Address parameters
            Address address = employee.getAddress();
            preparedStatement.setString(6, address.getStreetAddress());
            preparedStatement.setString(7, address.getApartment());
            preparedStatement.setString(8, address.getCity());
            preparedStatement.setString(9, address.getState());
            preparedStatement.setString(10, address.getPostalCode());
            preparedStatement.setString(11, address.getLandmark());
            
            preparedStatement.setString(12, employee.getPhoneNumber());
            preparedStatement.setInt(13, employee.getDepartmentId());
            preparedStatement.setString(14, employee.getJobTitle());
            preparedStatement.setDouble(15, employee.getSalary());
            preparedStatement.setString(16, employee.getWorkLocation());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new EmployeeDAOException("Error inserting employee.", e);
        }
    }

    @Override
    public Employee selectEmployee(int id) throws EmployeeDAOException {
        try (Connection connection = DatabaseConfigDAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    Employee employee = new Employee();
                    employee.setId(rs.getInt("id"));
                    employee.setFirstname(rs.getString("firstname"));
                    employee.setLastname(rs.getString("lastname"));
                    employee.setEmail(rs.getString("email"));
                    employee.setCountry(rs.getString("country"));
                    employee.setGender(rs.getString("gender"));
                    employee.setPhoneNumber(rs.getString("phoneNumber"));
                    employee.setDepartmentId(rs.getInt("departmentId"));
                    employee.setJobTitle(rs.getString("jobTitle"));
                    employee.setSalary(rs.getDouble("salary"));
                    employee.setWorkLocation(rs.getString("workLocation"));

                    // Address properties
                    Address address = new Address();
                    address.setStreetAddress(rs.getString("streetAddress"));
                    address.setApartment(rs.getString("apartment"));
                    address.setCity(rs.getString("city"));
                    address.setState(rs.getString("state"));
                    address.setPostalCode(rs.getString("postalCode"));
                    address.setLandmark(rs.getString("landmark"));
                    
                    // Set the Address object in Employee
                    employee.setAddress(address);

                    return employee;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new EmployeeDAOException("Error selecting employee by ID.", e);
        }
    }

    @Override
    public List<Employee> selectAllEmployees() throws EmployeeDAOException {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DatabaseConfigDAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES_SQL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String country = rs.getString("country");
                employees.add(new Employee(id, firstname, lastname, email, country));
            }
        } catch (SQLException e) {
            throw new EmployeeDAOException("Error selecting all employees.", e);
        }
        return employees;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws EmployeeDAOException {
        boolean rowUpdated = false;
        try (Connection connection = DatabaseConfigDAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL)) {
           
            preparedStatement.setString(1, employee.getFirstname());
            preparedStatement.setString(2, employee.getLastname());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getCountry());
            preparedStatement.setString(5, employee.getGender());
            
            // Set Address parameters
            preparedStatement.setString(6, employee.getAddress().getStreetAddress());
            preparedStatement.setString(7, employee.getAddress().getApartment());
            preparedStatement.setString(8, employee.getAddress().getCity());
            preparedStatement.setString(9, employee.getAddress().getState());
            preparedStatement.setString(10, employee.getAddress().getPostalCode());
            preparedStatement.setString(11, employee.getAddress().getLandmark());
            
            preparedStatement.setString(12, employee.getPhoneNumber());
            preparedStatement.setInt(13, employee.getDepartmentId());
            preparedStatement.setString(14, employee.getJobTitle());
            preparedStatement.setDouble(15, employee.getSalary());
            preparedStatement.setString(16, employee.getWorkLocation());
            preparedStatement.setInt(17, employee.getId()); // Add employee ID for the WHERE clause

            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new EmployeeDAOException("Error updating employee.", e);
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteEmployee(int id) throws EmployeeDAOException {
        boolean rowDeleted;
        try (Connection connection = DatabaseConfigDAO.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new EmployeeDAOException("Error deleting employee.", e);
        }
        return rowDeleted;
    }

    @Override
    public List<Employee> searchEmployeesByIDorFirstLastName(String searchTerm) throws EmployeeDAOException {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DatabaseConfigDAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_EMPLOYEES_BY_ID_OR_NAME_SQL)) {
            preparedStatement.setString(1, "%" + searchTerm + "%");
            preparedStatement.setString(2, "%" + searchTerm + "%");
            preparedStatement.setString(3, "%" + searchTerm + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String country = rs.getString("country");
                employees.add(new Employee(id, firstname, lastname, email, country));
            }
        } catch (SQLException e) {
            throw new EmployeeDAOException("Error searching employees by ID or First/Last Name.", e);
        }
        return employees;
    }
}
