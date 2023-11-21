package com.example.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("update".equals(action)) {
            // Forward to the update profile page
            request.getRequestDispatcher("/updateProfile.jsp").forward(request, response);
        } else {
            // Assume default action is to view the profile
            // Set some dummy attributes for demonstration purposes
        	
            request.setAttribute("username", "John Doe");
            request.setAttribute("email", "john.doe@example.com");

            // Forward to the view profile page
            request.getRequestDispatcher("/profile.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Update the profile information (dummy logic for demonstration)
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        // Update the attributes
        request.setAttribute("username", username);
        request.setAttribute("email", email);

        // Forward to the view profile page
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
    }
}
