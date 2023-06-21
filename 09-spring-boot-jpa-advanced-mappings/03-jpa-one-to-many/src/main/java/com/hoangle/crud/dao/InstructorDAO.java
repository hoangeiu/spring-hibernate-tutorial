package com.hoangle.crud.dao;

import com.hoangle.crud.entity.Course;
import com.hoangle.crud.entity.Instructor;
import com.hoangle.crud.entity.InstructorDetail;

import java.util.List;

public interface InstructorDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);
}
