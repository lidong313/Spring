package com.entity;

import java.io.Serializable;

public class Student implements Serializable{
    private static final long serialVersionUID = -8019929135094013110L;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
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
}
