package com.hoangle.udemy.dto;

import com.hoangle.udemy.entity.Student;

import java.util.List;

public class CourseAndStudentsDTO {
    private int id;

    private String title;

    private List<StudentDTO> students;

    public CourseAndStudentsDTO() {
    }

    public CourseAndStudentsDTO(int id, String title, List<StudentDTO> students) {
        this.id = id;
        this.title = title;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<StudentDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDTO> students) {
        this.students = students;
    }
}
