package com.hoangle.udemy.service;

import com.hoangle.udemy.entity.Course;

public interface CourseService {
    Course findCourseById(int theId);

    Course saveCourse(Course course);

    void deleteCourseById(int theId);

    Course findCourseAndStudentsByCourseId(int theId);
}
