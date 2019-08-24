package com.example.cs5610su19javaservercdesai.models;

public enum Role
{
    FACULTY("Faculty"),
    STUDENT("Student"),
    ADMIN("Admin");

    private String userRole;

    Role(String userRole) {
        this.userRole = userRole;
    }

    public String getUserRole() {
        return userRole;
    }
}
