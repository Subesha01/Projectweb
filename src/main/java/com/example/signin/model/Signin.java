package com.example.signin.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Signin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private String username;
    private String password;
    private String email;
    private String state;
    private String phone;

    public Signin() {
    }

    public Signin(int no, String username, String password, String email, String state, String phone) {
        this.no = no;
        this.username = username;
        this.password = password;
        this.email = email;
        this.state = state;
        this.phone = phone;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}