package com.StringManupulationExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class Main {
    public static class DuplicateRollNumberException extends RuntimeException {
        public DuplicateRollNumberException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        try {
            // Creating student objects
            Student student1 = new Student(101, "John Doe", 20, "Math");
            Student student2 = new Student(102, "Jane Smith", 21, "Science");
            Student student3 = new Student(103, "John Doe", 20, "Math"); 
            Student student4 = new Student(103, "John Doe", 20, "Math");// Duplicate rollNumber

            // Create an ArrayList 
            ArrayList<Student> studentList = new ArrayList<>();
            studentList.add(student1);
            studentList.add(student2);
            studentList.add(student3);
//            studentList.add(student4);
            
            System.out.println("Student List:");
            for (Student student : studentList) {
                System.out.println("Student:: " + student.getRollNumber() + "  " + student.getName() + "  " + student.getAge());
            }
            
            // Create a HashSet to store unique students
            try {
                HashSet<Student> studentSet = new HashSet<>();
                studentSet.add(student1);
                studentSet.add(student2);
                studentSet.add(student3); // Duplicate, won't be added
                
                System.out.println("\nStudent Set:");
                for (Student student : studentSet) {
                    System.out.println("Student:: " + student.getRollNumber() + "  " + student.getName() + "  " + student.getAge());
                }
            } catch (Exception e) {
                System.err.println("Error while working with HashSet: " + e.getMessage());
            }

            // Create a HashMap to store students by roll number
            try {
                HashMap<Integer, Student> studentMap = new HashMap<>();
                for (Student student : studentList) {
                    if (studentMap.containsKey(student.getRollNumber())) {
                        throw new DuplicateRollNumberException("Duplicate roll number: " + student.getRollNumber());
                    }
                    studentMap.put(student.getRollNumber(), student);
                }
                
                System.out.println("\nStudent HashMap:");
                for (Student student : studentMap.values()) {
                    System.out.println("Roll Number: " + student.getRollNumber() + " :: " + student.getName() + "  " + student.getAge());
                }
            } catch (Exception e) {
                System.err.println("Error while working with HashMap: " + e.getMessage());
            }

            // Create a TreeMap to store students by roll number
            try {
                TreeMap<Integer, Student> studentTreeMap = new TreeMap<>();
                for (Student student : studentList) {
                    studentTreeMap.put(student.getRollNumber(), student);
                }
                
                System.out.println("\nStudent TreeMap:");
                for (Student student : studentTreeMap.values()) {
                    System.out.println("Student:: " + student.getRollNumber() + "  " + student.getName() + "  " + student.getAge());
                }
            } catch (Exception e) {
                System.err.println("Error while working with TreeMap: " + e.getMessage());
            }

            // method overriding
            System.out.println("\nDisplaying Student Details: Using Method Overriding and Overloading");
            student1.displayDetails();

            //  method overloading
            
            Student newStudent = new Student(103, "Alice", 22, "Chemistry");
            newStudent.displayDetails();

            //  interface and custom exception
            try {
                newStudent.enroll("Biology");
                newStudent.enroll(""); // This will throw an EnrollmentException
            } catch (EnrollmentException e) {
                System.err.println("Enrollment Error: " + e.getMessage());
            }
            
            
            
            
            
         // Demonstrate String manipulation
            System.out.println("\n\nString manipulation:: \n");
            String fullName = student1.getName();
            System.out.println("Full Name: " + fullName);

            String upperName = fullName.toUpperCase();
            System.out.println("Upper Case Name: " + upperName);

            String replacedName = fullName.replace(' ', '-');
            System.out.println("Name with Replaced Spaces: " + replacedName);

            // String equality check
            boolean isEqual = student1.equals(student3);
            System.out.println("Are student1 and student3 equal? " + isEqual);

            // HashCode
            int hashCode1 = student1.hashCode();
            int hashCode3 = student3.hashCode();
            System.out.println("HashCode of student1: " + hashCode1);
            System.out.println("HashCode of student3: " + hashCode3);
            
            
            
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
