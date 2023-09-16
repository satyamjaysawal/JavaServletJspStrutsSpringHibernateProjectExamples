package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Student> students = new ArrayList<>();

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        
        // Check if ageStr is not null and not empty
        if (email != null && !email.isEmpty() || name !=null && !name.isEmpty()) {
            try {
            
                
                Student student = new Student(name, email);

                // Adding the student to the list
                students.add(student);

                // Display success message and list of students
                out.println("<html><head><title>Student Added</title></head><body>");
                out.println("<h2>Student Added Successfully ....</h2>");
                out.println("<p>Name: " + name + "</p>");
                out.println("<p>Email: " + email + "</p>");
                out.println("<h2>List of Students:</h2>");
                out.println("<ol>");

                for (Student s : students) {
                    out.println("<li>Name: " + s.getName() + ",<br> Email: " + s.getEmail() + "</li>");
                }

                out.println("</ol>");
                out.println("<a href='index.jsp'>Back to Form</a>");

                // Go to WelcomeServlet page
                out.println("<form action='WelcomeServlet' method='get'>");
                out.println("<input type='submit' value='Go to Welcome Page'>");
                out.println("</form>");

                out.println("</body></html>");
            } catch (NumberFormatException e) {
                // Handle the case where ageStr is not a valid integer
                out.println("<html><head><title>Invalid Age</title></head><body>");
                out.println("<h2>Invalid Email: Please enter a valid number.</h2>");
                out.println("<a href='index.jsp'>Back to Form</a>");
                out.println("</body></html>");
            }
        } else {
            // Handle the case where ageStr is empty
            out.println("<html><head><title>Invalid Age</title></head><body>");
            out.println("<h2>Invalid Name: Age field cannot be empty.</h2>");
            out.println("<h2>Invalid Email: Name cannot be empty.</h2>");
            out.println("<a href='index.jsp'>Back to Form</a>");
            out.println("</body></html>");
        }

        out.close();
    }
}
