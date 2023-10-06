package com.example.DAO;

import java.util.List;

import com.example.Employee;

public interface EmployeeDAOInterface {
    void insertEmployee(Employee employee) throws EmployeeDAOException;
    Employee selectEmployee(int id) throws EmployeeDAOException;
    List<Employee> selectAllEmployees() throws EmployeeDAOException;
    boolean updateEmployee(Employee employee) throws EmployeeDAOException;
    boolean deleteEmployee(int id) throws EmployeeDAOException;
    List<Employee> searchEmployeesByInput(String searchTerm) throws EmployeeDAOException;
	
}
