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

        // Creating a scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Switch case for different operations
        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Add a student");
            System.out.println("2. View all students");
            System.out.println("3. Delete a student");
            System.out.println("4. Update a student's name");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // to clear the buffer

            switch (choice) {
                case 1:
                    System.out.println("Enter student details:");
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.println("Enter college name: ");
                    String collegeName = scanner.nextLine();
                    System.out.println("Enter email: ");
                    String email = scanner.nextLine();
                    Student newStudent = new Student(name, address, collegeName, email);
                    studentDAO.saveStudent(newStudent);
                    System.out.println("Student added successfully.");
                    break;
                case 2:
                    List<Student> studentList = studentDAO.getAllStudents();
                    System.out.println("List of all students:");
                    for (Student student : studentList) {
                        System.out.println(student.toString());
                    }
                    break;
                case 3:
                    System.out.println("Enter the student ID to delete: ");
                    int studentId = scanner.nextInt();
                    studentDAO.deleteStudent(studentId);
                    break;
                case 4:
                    System.out.println("Enter the student ID to update: ");
                    int studentIdUp = scanner.nextInt();
                    System.out.println("Enter updated name: ");
                    scanner.nextLine(); // to clear the buffer
                    String updatedName = scanner.nextLine();
                    studentDAO.updateStudent(studentIdUp, updatedName);
                    break;
                case 5:
                    System.out.println("Exiting the application...");
                    scanner.close();
                    factory.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
