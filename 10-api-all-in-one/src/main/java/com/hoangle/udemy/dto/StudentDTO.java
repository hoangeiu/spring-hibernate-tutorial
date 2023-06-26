package com.hoangle.udemy.dto;

import jakarta.persistence.Column;

import java.util.List;

public class StudentDTO {
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private List<CourseDTO> courses;

    public StudentDTO() {
    }

    public StudentDTO(int id, String firstName, String lastName, String email, List<CourseDTO> courses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.courses = courses;
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

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDTO> courses) {
        this.courses = courses;
    }
}
