package com.example;
public class Employee {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String country;
    private String gender;
    private String phoneNumber;
    private int departmentId;
    private String jobTitle;
    private double salary;
    private String workLocation;
    
    
    private Address address;

    public Employee() {
    }

    public Employee(String firstname,String lastname, String email, String country) {
        this.firstname = firstname;
        this.lastname= lastname;
        this.email = email;
        this.country = country;
    }

    public Employee(int id, String firstname,String lastname, String email, String country) {
        this.id = id;
        this.firstname = firstname;
        this.lastname= lastname;
        this.email = email;
        this.country = country;
    }

    public Employee(String firstname, String lastname, String email, String country, String gender, String phoneNumber, int departmentId, String jobTitle, double salary, String workLocation, Address address) {
		 this.firstname = firstname;
	     this.lastname= lastname;
        this.email = email;
        this.country = country;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.departmentId = departmentId;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.workLocation = workLocation;
        this.address = address;
    }

    public Employee(int id, String firstname, String lastname, String email, String country, String gender, String phoneNumber, int departmentId, String jobTitle, double salary, String workLocation, Address address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname= lastname;
        this.email = email;
        this.country = country;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.departmentId = departmentId;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.workLocation = workLocation;
        this.address = address; 
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  

    public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    // Getter and setter for the address field

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
