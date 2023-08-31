package com.FullJavaJdbcFileCollectionCustom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentDAO {

    // Case 1: Insert students into the database
	public static void insertStudent(Student student) {
        String query = "INSERT INTO students (id, name, age, course) VALUES (?, ?, ?, ?)";

        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getCourse());

            preparedStatement.executeUpdate();
            System.out.println("Student data inserted into the database.");
        } catch (SQLException e) {
            System.err.println("Error inserting student data: " + e.getMessage());
        }
    }

    public static void insertStudentsIntoDatabase(List<Student> students) {
        for (Student student : students) {
            insertStudent(student);
        }
        System.out.println("Student data inserted into the database.");
    }
 // Case 2: Fetch students from the database
    public static void fetchStudentsFromDatabase() {
        List<Student> students = new ArrayList<>();
        Connection connection = null;

        try {
            connection = DbConnection.getConnection();
            String query = "SELECT * FROM students";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    String course = resultSet.getString("course");
                    students.add(new Student(id, name, age, course));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error executing SQL query: " + e.getMessage());
        } 
        }

 


   
	private static void enrollStudents(List<Student> students) {
		// TODO Auto-generated method stub
		
	}

	// Case 3: Display details of all students
    public static void displayStudentDetails(List<Student> students) {
        System.out.println("Student Details:");
        for (Student student : students) {
            student.displayDetails();
        }
    }

    // Case 4: Sort students by name and display
    public static void sortStudentsByName(List<Student> students) {
        Collections.sort(students);
        System.out.println("Sorted Student Details (by name):");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Case 5: Sort students by ID and display
    public static void sortStudentsById(List<Student> students) {
        Collections.sort(students, Comparator.comparingInt(Student::getId));
        System.out.println("Sorted Student Details (by ID):");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Case 6: Filter and display students aged 18 and above
    public static void filterStudentsByAge(List<Student> students) {
        List<Student> filteredStudents = students.stream()
                .filter(student -> student.getAge() >= 18)
                .collect(Collectors.toList());
        System.out.println("Students aged 18 and above:");
        for (Student student : filteredStudents) {
            System.out.println(student);
        }
    }
 // Case 7: Search and display students by exact name match
    public static void searchStudentsExactMatch(List<Student> students) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a name to search for students (exact match): ");
            String searchName = scanner.nextLine();
            boolean found = false;

            for (Student student : students) {
                if (student.getName().equals(searchName)) {
                    System.out.println("Student found:");
                    System.out.println(student);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Student not found.");
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }




    // Case 8: Demonstrate string manipulation techniques
    public static void demonstrateStringManipulation() {
        String str = "Hello, ";
        String name = "Alice";
        String concatenated = str + name;
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(name);
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.append(name);
        System.out.println("Concatenated using String: " + concatenated);
        System.out.println("Using StringBuffer: " + stringBuffer.toString());
        System.out.println("Using StringBuilder: " + stringBuilder.toString());
    }

    // Case 9: Demonstrate Object class methods
    public static void demonstrateObjectClass(List<Student> students) {
        Object obj1 = students.get(0);
        Object obj2 = students.get(1);
        System.out.println("obj1 equals obj2? " + obj1.equals(obj2));
        System.out.println("obj1 class: " + obj1.getClass());
        System.out.println("obj1 hashCode: " + obj1.hashCode());
        System.out.println("obj2 toString: " + obj2.toString());
    }
}
