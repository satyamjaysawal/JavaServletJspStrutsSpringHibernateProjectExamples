package com.StringManupulationExample;

public class Student extends Person implements Enrollable {
    private int rollNumber;
    private String name;
    private int age;
    private String course;

    public Student(int rollNumber, String name, int age, String course) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    @Override
    public void enroll(String course) throws EnrollmentException {
        if (course == null || course.isEmpty()) {
            throw new EnrollmentException("Course name cannot be empty.");
        }
        this.course = course;
        System.out.println(name + " enrolled in " + course);
    }
    
    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return rollNumber;
    }

  

    @Override
    public String toString() {
        return "Student{" +"rollNumber=" + rollNumber +", name='" + name + '\'' +", age=" + age +", course='" + course + '\'' +'}';
    }

    @Override
    public void displayDetails() {
        System.out.println("\n"+"Student Details: Roll Number: " + rollNumber + ", Name: " + name + ", Age: " + age + ", Course: " + course);
    }


    public String getCourse() {
        return course;
    }
    
    
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        return rollNumber == other.rollNumber;
    }
}

