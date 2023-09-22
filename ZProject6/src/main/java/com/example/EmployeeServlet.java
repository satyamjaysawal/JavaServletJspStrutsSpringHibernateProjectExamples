package com.example;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDAOInterface employeeDAO;

    public void init() {
        employeeDAO = new EmployeeDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertEmployee(request, response);
                    break;
                case "/delete":
                    deleteEmployee(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateEmployee(request, response);
                    break;
                case "/search":
                    searchEmployeesByName(request, response);
                    break;
                case "/sort":
                    sortEmployees(request, response);
                    break;
                case "/details":
                    showEmployeeDetails(request, response);
                    break;
                default:
                    listEmployees(request, response);
                    break;
            }
        } catch (EmployeeDAOException | SQLException | ServletException | IOException e) {
            e.printStackTrace();
            response.getWriter().write("An error occurred: " + e.getMessage());
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void sortEmployees(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, EmployeeDAOException, SQLException {
        String sortCriteria = request.getParameter("sortCriteria");
        List<Employee> listEmployee = employeeDAO.selectAllEmployees();

        // Create an instance of EmployeeSortingCriteria
        EmployeeSortingCriteria sortingCriteria = new EmployeeSortingCriteria();

        // Apply sorting based on the selected criteria
        Comparator<Employee> comparator;
        switch (sortCriteria) {
            case "name":
                comparator = sortingCriteria.getComparatorByName();
                break;
            case "email":
                comparator = sortingCriteria.getComparatorByEmail();
                break;
            case "country":
                comparator = sortingCriteria.getComparatorByCountry();
                break;
            // Add more cases for additional sorting criteria
            default:
                // Default sorting (e.g., by name)
                comparator = sortingCriteria.getComparatorByName();
                break;
        }

        // Sort the list using the selected comparator
        Collections.sort(listEmployee, comparator);

        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
        dispatcher.forward(request, response);
    }

    private void listEmployees(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, EmployeeDAOException, SQLException {
        List<Employee> listEmployee = employeeDAO.selectAllEmployees();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, EmployeeDAOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee existingEmployee = employeeDAO.selectEmployee(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
        request.setAttribute("employee", existingEmployee);
        dispatcher.forward(request, response);
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
            throws IOException, EmployeeDAOException, SQLException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        Employee newEmployee = new Employee(name, email, country);
        employeeDAO.insertEmployee(newEmployee);
        response.sendRedirect("list");
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
            throws IOException, EmployeeDAOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        Employee updatedEmployee = new Employee(id, name, email, country);
        employeeDAO.updateEmployee(updatedEmployee);
        response.sendRedirect("list");
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
            throws IOException, EmployeeDAOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeDAO.deleteEmployee(id);
        response.sendRedirect("list");
    }

    private void searchEmployeesByName(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, EmployeeDAOException, SQLException {
        String searchName = request.getParameter("searchName");
        List<Employee> searchResults = employeeDAO.searchEmployeesByName(searchName);
        request.setAttribute("listEmployee", searchResults);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEmployeeDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, EmployeeDAOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeDAO.selectEmployee(id);
        request.setAttribute("employee", employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-details.jsp");
        dispatcher.forward(request, response);
    }
}
