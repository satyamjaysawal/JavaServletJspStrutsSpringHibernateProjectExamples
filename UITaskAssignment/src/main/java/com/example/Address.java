package com.example;

public class Address {
    private String streetAddress;
    private String apartment;
    private String city;
    private String state;
    private String postalCode;
    private String landmark;

    
    public Address() {
        
    }

    public Address(String streetAddress, String apartment, String city, String state, String postalCode, String landmark) {
        this.streetAddress = streetAddress;
        this.apartment = apartment;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.landmark = landmark;
    }

   
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", apartment='" + apartment + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", landmark='" + landmark + '\'' +
                '}';
    }
}
