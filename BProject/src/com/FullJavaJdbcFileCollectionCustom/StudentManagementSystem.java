package com.FullJavaJdbcFileCollectionCustom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {
    public static void main(String[] args) throws Exception {
        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Alice", 20, "Math"));
        students.add(new Student(2, "Bob", 22, "Science"));
        students.add(new Student(3, "Alex", 24, "Physics"));
        students.add(new Student(4, "John", 21, "Chemistry"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Insert students into the database");
           
            System.out.println("3. Display student details on console");
            System.out.println("4. Sort students by name");
            System.out.println("5. Sort students by ID");
            System.out.println("6. Filter students by age");
            System.out.println("7. Search students by name");
            System.out.println("8. Demonstrate string manipulation");
            System.out.println("9. Demonstrate Object class methods");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (choice == 0) {
                System.out.println("Exiting the program.");
                break;
            }

            performOperation(choice, students);
        }

        scanner.close();
    }

    private static void performOperation(int choice, List<Student> students) throws Exception {
        switch (choice) {
            case 1:
                StudentDAO.insertStudentsIntoDatabase(students);
                break;
            case 2:
                StudentDAO.fetchStudentsFromDatabase();
                break;

            case 3:
                StudentDAO.displayStudentDetails(students);
                break;
            case 4:
                StudentDAO.sortStudentsByName(students);
                break;
            case 5:
                StudentDAO.sortStudentsById(students);
                break;
            case 6:
                StudentDAO.filterStudentsByAge(students);
                break;
            case 7:
                StudentDAO.searchStudentsExactMatch(students);
                break;
            case 8:
                StudentDAO.demonstrateStringManipulation();
                break;
            case 9:
                StudentDAO.demonstrateObjectClass(students);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
