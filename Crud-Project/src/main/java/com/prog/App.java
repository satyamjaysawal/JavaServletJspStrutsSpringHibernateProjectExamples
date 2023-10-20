package com.prog;

import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, Starting the Application...");

        // Initializing the Hibernate session factory
        SessionFactory factory = HibernateUtil.getSessionFactory();

        // Creating an instance of HibernateStudentDAO
        StudentDAO studentDAO = new HibernateStudentDAO(factory);

        // Save a student
        Student st = new Student("Becoder1", "India1", "Uk University", "sj@gmail.com");
        studentDAO.saveStudent(st);
        System.out.println("Student registration successful.");

        // Retrieve all students
        List<Student> studentList = studentDAO.getAllStudents();
        System.out.println("List of all students:");
        for (Student student : studentList) {
            System.out.println(student.toString());
        }

        // Delete student based on ID
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the student ID to delete: ");
            int studentId = scanner.nextInt();
            studentDAO.deleteStudent(studentId);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        // Update student based on ID
        try {
            Scanner upScanner = new Scanner(System.in);
            System.out.println("Enter the student ID to update: ");
            int studentIdUp = upScanner.nextInt();
            System.out.println("Enter updated name: ");
            upScanner.nextLine(); // to clear the buffer
            String updatedName = upScanner.nextLine();
            studentDAO.updateStudent(studentIdUp, updatedName);
            upScanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }

        // Closing the Hibernate session factory
        factory.close();
    }
}
