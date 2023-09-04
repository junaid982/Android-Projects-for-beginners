package com.example.androidwithsqlitedatabase.model;

import java.io.Serializable;

public class Contact implements Serializable {

    private int id;
    private String name;
    private String phoneNumber;

    // ========================= constructor start from here
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Contact(int id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Contact() {
    }

    // ========================= constructor End here

    // getter and setter method for id ,name and phoneNumber


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}













