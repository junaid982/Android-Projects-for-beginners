package com.example.androiddatabase.model;

public class Contact {

    private int id;
    private String name;
    private String phoneNumber;

    public Contact(String name , String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Contact(int id , String name , String phoneNumber){
        this .id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Contact(){
    }

//    getter and setter for id
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }


//    getter and setter for name

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

//    getter and setter for phone number

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }


}


















