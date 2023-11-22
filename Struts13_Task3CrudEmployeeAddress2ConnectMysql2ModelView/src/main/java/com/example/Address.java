package com.example;

public class Address {
    private String city;
    private String district;

    // Constructors, getters, and setters

    public Address() {
        // Default constructor
    }

    public Address(String city, String district) {
        this.city = city;
        this.district = district;
    }

    // Getters and setters

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
