package com.StringManupulationExample2;

public class StringManipulation {
    public static void main(String[] args) {
        // Creating student objects
        Student student1 = new Student(101, "John Doe", 20);
        Student student3 = new Student(101, "John Doe", 20); // Duplicate rollNumber
        
        // String manipulation
        
        
        System.out.println("\n\n\n");
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
    }
}
