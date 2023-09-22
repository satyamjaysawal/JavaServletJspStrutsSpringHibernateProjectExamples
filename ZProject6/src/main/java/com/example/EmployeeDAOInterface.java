package com.example;

import java.util.List;

public interface EmployeeDAOInterface {
    void insertEmployee(Employee employee) throws EmployeeDAOException;

    Employee selectEmployee(int id) throws EmployeeDAOException;

    List<Employee> selectAllEmployees() throws EmployeeDAOException;

    boolean updateEmployee(Employee employee) throws EmployeeDAOException;

    boolean deleteEmployee(int id) throws EmployeeDAOException;

    List<Employee> searchEmployeesByName(String name) throws EmployeeDAOException;
}
