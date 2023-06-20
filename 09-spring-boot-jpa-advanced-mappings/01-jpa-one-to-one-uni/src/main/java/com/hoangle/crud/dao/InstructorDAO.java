package com.hoangle.crud.dao;

import com.hoangle.crud.entity.Instructor;

public interface InstructorDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);
}
