package com.example;

public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private Address address; // Assuming you have an Address class

    // Constructors, getters, and setters

    public Employee() {
        // Default constructor
    }

    public Employee(int employeeId, String firstName, String lastName, Address address) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    // Getters and setters for each field

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // Additional methods as needed
}
