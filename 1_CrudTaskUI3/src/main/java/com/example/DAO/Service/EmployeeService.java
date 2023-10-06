package com.example.DAO.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;



import com.example.DAO.EmployeeDAOException;


public interface EmployeeService {
    void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, EmployeeDAOException ;
    
    void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws EmployeeDAOException, IOException;
    
    void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, EmployeeDAOException;
    
    void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, EmployeeDAOException;
    
    void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, EmployeeDAOException;
    
    void searchEmployeesByInput(HttpServletRequest request, HttpServletResponse response) throws EmployeeDAOException, ServletException, IOException;
    
    void sortEmployees(HttpServletRequest request, HttpServletResponse response) throws EmployeeDAOException, ServletException, IOException;
    
    void showEmployeeDetails(HttpServletRequest request, HttpServletResponse response) throws EmployeeDAOException, ServletException, IOException;
    
    void listEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, EmployeeDAOException;
}
