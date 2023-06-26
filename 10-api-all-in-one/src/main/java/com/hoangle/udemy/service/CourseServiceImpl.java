package com.hoangle.udemy.service;

import com.hoangle.udemy.entity.Course;
import com.hoangle.udemy.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{
    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course findCourseById(int theId) {
        Optional<Course> result = courseRepository.findById(theId);

        Course course = null;
        if (result.isPresent()) {
            course = result.get();
        } else {
            throw new RuntimeException("Did not found course id - " + theId);
        }

        return course;
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourseById(int theId) {
        courseRepository.deleteById(theId);
    }

    @Override
    public Course findCourseAndStudentsByCourseId(int theId) {
        Course course = courseRepository.findCourseAndStudentsByCourseId(theId);

        if (course == null) {
            throw new RuntimeException("Did not found course id - " + theId);
        }

        return course;
    }
}
