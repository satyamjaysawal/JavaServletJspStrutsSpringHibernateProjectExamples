package com.example.DAO.Service;

import java.io.IOException;


import com.example.DAO.EmployeeDAOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeService employeeService;

    public void init() {
        employeeService = new EmployeeServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
        	if ("/new".equals(action)) {
        	    employeeService.showNewForm(request, response);
        	} else if ("/insert".equals(action)) {
        	    employeeService.insertEmployee(request, response);
        	} else if ("/delete".equals(action)) {
        	    employeeService.deleteEmployee(request, response);
        	} else if ("/edit".equals(action)) {
        	    employeeService.showEditForm(request, response);
        	} else if ("/update".equals(action)) {
        	    employeeService.updateEmployee(request, response);
        	} else if ("/search".equals(action)) {
        	    employeeService.searchEmployeesByInput(request, response);
        	} else if ("/sort".equals(action)) {
        	    employeeService.sortEmployees(request, response);
        	} else if ("/details".equals(action)) {
        	    employeeService.showEmployeeDetails(request, response);
        	} else {
        	    employeeService.listEmployees(request, response);
        	}
        } catch (EmployeeDAOException e) {
        	e.printStackTrace();
            request.setAttribute("error", e.getMessage());
            RequestDispatcher errorDispatcher = request.getRequestDispatcher("error.jsp");
            errorDispatcher.forward(request, response);
        } 
      
    }
}
