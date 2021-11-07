package com.example.demo.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Employee {
    @JsonIgnore
    private int id;
    @Size(min = 5, max = 30, message = "Name must between 5 and 30")
    private String firstName;
    @Size(min = 5, max = 30, message = "Name must between 5 and 30")
    private String lastName;
    @Email(message = "Not valid email")
    private String email;
    private String idCard;

    public Employee() {
    }

    public Employee(int id, @Size(min = 5, max = 30, message = "Name must between 5 and 30") String firstName,
            @Size(min = 5, max = 30, message = "Name must between 5 and 30") String lastName, @Email(message = "Not valid email") String email,
            String idCard) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.idCard = idCard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }

    public boolean matchWithKeyword(String keyword) {
        String keywordLowerCase = keyword.toLowerCase();
        return (fullName().toLowerCase().contains(keywordLowerCase) || email.toLowerCase().contains(keywordLowerCase));
    }
}
