package com.hoangle.udemy.service;

import com.hoangle.udemy.entity.Student;

public interface StudentService {
    Student findStudentAndCoursesByStudentId(int theId);

    void update(Student student);

    void deleteStudentById(int theId);
}
