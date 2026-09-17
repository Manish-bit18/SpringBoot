package com.demo.hibernatedemo.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String houseNo;
    private String street;
    private String city;
    private String state;
    private String pincode;

    public Address() {
    }

    public Address(String street, String houseNo, String city, String state, String pincode) {
        this.street = street;
        this.houseNo = houseNo;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getpincode() {
        return pincode;
    }

    public void setpincode(String pincode) {
        this.pincode = pincode;
    }
}
