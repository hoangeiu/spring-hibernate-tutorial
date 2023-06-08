package com.hoangle.cruddemo.dao;

import com.hoangle.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);
}
