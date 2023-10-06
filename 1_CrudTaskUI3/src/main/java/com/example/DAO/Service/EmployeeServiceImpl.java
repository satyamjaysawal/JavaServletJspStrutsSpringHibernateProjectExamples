package com.example.DAO.Service;

import com.example.Address;
import com.example.Employee;
import com.example.EmployeeSortingCriteria;
import com.example.DAO.EmployeeDAOException;
import com.example.DAO.EmployeeDAOImpl;
import com.example.DAO.EmployeeDAOInterface;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAOInterface employeeDAO;

    public EmployeeServiceImpl() {
        employeeDAO = new EmployeeDAOImpl();
    }

    @Override
    public void sortEmployees(HttpServletRequest request, HttpServletResponse response)
            throws  EmployeeDAOException, ServletException, IOException{
        try {
            String sortCriteria = request.getParameter("sortCriteria");
            if (sortCriteria == null) {
                sortCriteria = "firstname";
            }
            List<Employee> listEmployee = employeeDAO.selectAllEmployees();
            EmployeeSortingCriteria sortingCriteria = new EmployeeSortingCriteria();
            Map<String, Comparator<Employee>> comparatorMap = new HashMap<>();

            if ("lastname".equals(sortCriteria)) {
                comparatorMap.put("lastname", Collections.reverseOrder(sortingCriteria.getComparatorByLastName()));
            } else {
                comparatorMap.put("lastname", sortingCriteria.getComparatorByLastName());
            }

            comparatorMap.put("firstname", sortingCriteria.getComparatorByFirstName());
            comparatorMap.put("email", sortingCriteria.getComparatorByEmail());
            comparatorMap.put("country", sortingCriteria.getComparatorByCountry());
            Comparator<Employee> defaultComparator = sortingCriteria.getComparatorByFirstName();
            Comparator<Employee> comparator = comparatorMap.getOrDefault(sortCriteria, defaultComparator);
            Collections.sort(listEmployee, comparator);

            request.setAttribute("listEmployee", listEmployee);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
            dispatcher.forward(request, response);
        } catch (EmployeeDAOException e) {
            throw new EmployeeDAOException("Error sorting employees.", e);
        }
    }

    @Override
    public void listEmployees(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, EmployeeDAOException {
        try {
            List<Employee> listEmployee = employeeDAO.selectAllEmployees();
            request.setAttribute("listEmployee", listEmployee);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
            dispatcher.forward(request, response);
        } catch (EmployeeDAOException e) {
            throw new EmployeeDAOException("Error listing employees.", e);
        }
    }

    @Override
    public void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, EmployeeDAOException {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
            dispatcher.forward(request, response);
        } catch (IOException | ServletException e) {
            throw new EmployeeDAOException("Error forwarding the request.", e);
        }
    }

    @Override
    public void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, EmployeeDAOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Employee existingEmployee = employeeDAO.selectEmployee(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
            request.setAttribute("employee", existingEmployee);
            dispatcher.forward(request, response);
        } catch (EmployeeDAOException e) {
            throw new EmployeeDAOException("Error showing edit form.", e);
        } 
    }




    @Override
    public void insertEmployee(HttpServletRequest request, HttpServletResponse response)
            throws EmployeeDAOException, IOException{
        try {
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
        } catch (EmployeeDAOException e) {
            throw new EmployeeDAOException("Error inserting employee.", e);
        }
    }

    @Override
    public void updateEmployee(HttpServletRequest request, HttpServletResponse response)
            throws IOException, EmployeeDAOException {
        try {
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
        } catch (EmployeeDAOException e) {
            throw new EmployeeDAOException("Error updating employee.", e);
        }
    }


    @Override
    public void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
            throws  EmployeeDAOException, IOException{
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            employeeDAO.deleteEmployee(id);
            response.sendRedirect("list");
        } catch (EmployeeDAOException e) {
            throw new EmployeeDAOException("Error deleting employee.", e);
        }
    }

    @Override
    public void searchEmployeesByInput(HttpServletRequest request, HttpServletResponse response)
            throws EmployeeDAOException, ServletException, IOException {
        try {
            String searchTerm = request.getParameter("searchTerm");
            List<Employee> searchResults = employeeDAO.searchEmployeesByInput(searchTerm);

            request.setAttribute("listEmployee", searchResults);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
            dispatcher.forward(request, response);
        } catch (EmployeeDAOException e) {
            throw new EmployeeDAOException("Error searching employees.", e);
        }
    }





    @Override
    public void showEmployeeDetails(HttpServletRequest request, HttpServletResponse response)
            throws EmployeeDAOException, ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Employee employee = employeeDAO.selectEmployee(id);
            request.setAttribute("employee", employee);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee-details.jsp");
            dispatcher.forward(request, response);
        } catch (EmployeeDAOException e) {
            throw new EmployeeDAOException("Error retrieving employee details.", e);
        }
    }


}
