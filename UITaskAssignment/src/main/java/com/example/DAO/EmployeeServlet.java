package com.example.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.Address;
import com.example.Employee;
import com.example.EmployeeSortingCriteria;

import java.text.ParseException;

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
            if ("/new".equals(action)) {
                showNewForm(request, response);
            } else if ("/insert".equals(action)) {
                insertEmployee(request, response);
            } else if ("/delete".equals(action)) {
                deleteEmployee(request, response);
            } else if ("/edit".equals(action)) {
                showEditForm(request, response);
            } else if ("/update".equals(action)) {
                updateEmployee(request, response);
            } else if ("/search".equals(action)) {
              	searchEmployeesByFirstLastName(request, response);
            } else if ("/sort".equals(action)) {
                sortEmployees(request, response);
            } else if ("/details".equals(action)) {
                showEmployeeDetails(request, response);
            } else {
                listEmployees(request, response);
            }
        } catch (EmployeeDAOException e) {
            // Handle EmployeeDAOException for other methods here
            request.setAttribute("error", e.getMessage());
            RequestDispatcher errorDispatcher = request.getRequestDispatcher("error.jsp");
            errorDispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private void sortEmployees(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, EmployeeDAOException, SQLException {
        String sortCriteria = request.getParameter("sortCriteria");
        if (sortCriteria == null) {
            sortCriteria = "firstname";
        }
        List<Employee> listEmployee = employeeDAO.selectAllEmployees();
        EmployeeSortingCriteria sortingCriteria = new EmployeeSortingCriteria();
        Map<String, Comparator<Employee>> comparatorMap = new HashMap<>();
        comparatorMap.put("firstname", sortingCriteria.getComparatorByFirstName());
        comparatorMap.put("lastname", sortingCriteria.getComparatorByLastName());
        comparatorMap.put("email", sortingCriteria.getComparatorByEmail());
        comparatorMap.put("country", sortingCriteria.getComparatorByCountry());
        Comparator<Employee> defaultComparator = sortingCriteria.getComparatorByFirstName();
        Comparator<Employee> comparator = comparatorMap.getOrDefault(sortCriteria, defaultComparator);
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
            throws IOException, EmployeeDAOException, SQLException, ParseException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        String gender = request.getParameter("gender");
        String streetAddress = request.getParameter("streetAddress");
        String apartment = request.getParameter("apartment");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String postalCode = request.getParameter("postalCode");
        String landmark = request.getParameter("landmark");
        String phoneNumber = request.getParameter("phoneNumber");
        int departmentId = Integer.parseInt(request.getParameter("departmentId"));
        String jobTitle = request.getParameter("jobTitle");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String workLocation = request.getParameter("workLocation");

        Address address = new Address(streetAddress, apartment, city, state, postalCode, landmark);
        Employee newEmployee = new Employee(firstname, lastname, email, country, gender, phoneNumber, departmentId,
                jobTitle, salary, workLocation, address);
        employeeDAO.insertEmployee(newEmployee);
        response.sendRedirect("list");
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
            throws IOException, EmployeeDAOException, SQLException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        String gender = request.getParameter("gender");
        String streetAddress = request.getParameter("streetAddress");
        String apartment = request.getParameter("apartment");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String postalCode = request.getParameter("postalCode");
        String landmark = request.getParameter("landmark");
        String phoneNumber = request.getParameter("phoneNumber");
        int departmentId = Integer.parseInt(request.getParameter("departmentId"));
        String jobTitle = request.getParameter("jobTitle");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String workLocation = request.getParameter("workLocation");

        Address address = new Address(streetAddress, apartment, city, state, postalCode, landmark);
        Employee updatedEmployee = new Employee(id, firstname, lastname, email, country, gender, phoneNumber,
                departmentId, jobTitle, salary, workLocation, address);
        employeeDAO.updateEmployee(updatedEmployee);
        response.sendRedirect("details?id=" + id);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
            throws IOException, EmployeeDAOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeDAO.deleteEmployee(id);
        response.sendRedirect("list");
    }

    private void searchEmployeesByFirstLastName(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, EmployeeDAOException, SQLException {
        String searchCriteria = request.getParameter("searchCriteria");
        String searchTerm = request.getParameter("searchTerm");
        List<Employee> searchResults;

        if ("id".equals(searchCriteria)) {
            try {
                int id = Integer.parseInt(searchTerm);
                Employee employee = employeeDAO.selectEmployee(id);
                searchResults = (employee != null) ? Collections.singletonList(employee) : Collections.emptyList();
            } catch (NumberFormatException e) {
                // Handle incorrect input value for ID search
                request.setAttribute("error", "Enter a valid Employee ID");
                searchResults = Collections.emptyList();
            }
        } else if ("firstname".equals(searchCriteria) || "lastname".equals(searchCriteria)) {
            // Handle name-based search criteria, including integer input for name search
            searchResults = employeeDAO.searchEmployeesByIDorFirstLastName(searchTerm);
        } else {
            searchResults = Collections.emptyList();
        }

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
