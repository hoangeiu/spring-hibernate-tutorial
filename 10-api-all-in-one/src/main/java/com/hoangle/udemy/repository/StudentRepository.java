package com.hoangle.udemy.repository;

import com.hoangle.udemy.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s JOIN FETCH s.courses WHERE s.id = :id")
    Student findStudentAndCoursesByStudentId(@Param("id") int theId);
}
