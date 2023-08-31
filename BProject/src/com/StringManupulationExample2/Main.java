package com.StringManupulationExample2;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Creating student objects
        Student student1 = new Student(101, "John Doe", 20);
        Student student2 = new Student(102, "Jane Smith", 21);
        Student student3 = new Student(101, "John Doe", 20); // Duplicate rollNumber
        
        // Create an ArrayList and add student1 and student2 to it
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);

        // Create a HashMap to store students by roll number
        HashMap<Integer, Student> studentMap = new HashMap<>();
        for (Student student : studentList) {
            studentMap.put(student.getRollNumber(), student);
        }

        // Iterate through the ArrayList and print student details
        System.out.println("Student List:");
        for (Student student : studentList) {
            System.out.println("Student:: " + student.getRollNumber() + "  " + student.getName() + "  " + student.getAge());
        }

        // Iterate through the HashMap and print student details
        System.out.println("Student Map:");
        for (Student student : studentMap.values()) {
            System.out.println("Student:: " + student.getRollNumber() + "  " + student.getName() + "  " + student.getAge());
        }
    }
}
