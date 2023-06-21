package com.hoangle.crud.dao;

import com.hoangle.crud.entity.Instructor;
import com.hoangle.crud.entity.InstructorDetail;

public interface InstructorDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);
}
