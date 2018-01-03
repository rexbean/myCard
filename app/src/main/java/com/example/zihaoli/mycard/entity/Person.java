package com.example.zihaoli.mycard.entity;

/**
 * Created by zihaoli on 18/1/3.
 */

public class Person {
    /* lastName
    firstName
    email
    company
    startDate - date and time in ISO 8601 format
    bio - A small paragraph that may contain basic Markdown (asterisks to represent bold, underlines to represent italics)
    avatar - a URL for a 300x300px image
       */
    private int id;
    private String lastName;
    private String firstName;
    private String email;
    private String company;
    private String startDate;
    private String bio;
    private String avatar;

    public Person(int id, String lastName, String firstName, String email, String company, String startDate, String bio, String avatar) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.company = company;
        this.startDate = startDate;
        this.bio = bio;
        this.avatar = avatar;
    }

    public int getId(){
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany(){
        return company;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getBio() {
        return bio;
    }

    public String getAvatar() {
        return avatar;
    }
}
