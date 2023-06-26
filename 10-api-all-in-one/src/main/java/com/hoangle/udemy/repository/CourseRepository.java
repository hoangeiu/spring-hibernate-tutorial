package com.hoangle.udemy.repository;

import com.hoangle.udemy.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query("SELECT c FROM Course c JOIN FETCH c.students WHERE c.id = :id")
    Course findCourseAndStudentsByCourseId(@Param("id") int theId);
}
