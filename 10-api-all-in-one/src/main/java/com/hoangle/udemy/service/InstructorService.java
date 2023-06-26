package com.hoangle.udemy.service;

import com.hoangle.udemy.entity.Instructor;
import com.hoangle.udemy.entity.InstructorDetail;

public interface InstructorService {
    Instructor saveInstructor(Instructor instructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);
}
