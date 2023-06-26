package com.hoangle.udemy.rest;

import com.hoangle.udemy.dto.CourseDTO;
import com.hoangle.udemy.dto.StudentDTO;
import com.hoangle.udemy.entity.Course;
import com.hoangle.udemy.entity.Student;
import com.hoangle.udemy.service.CourseService;
import com.hoangle.udemy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private StudentService studentService;
    private CourseService courseService;

    @Autowired
    public StudentRestController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping("/student-courses/{studentId}")
    public Student getStudentAndCoursesByStudentId(@PathVariable int studentId) {
        return studentService.findStudentAndCoursesByStudentId(studentId);
    }

    @PutMapping("/student-courses")
    public Student addMoreCoursesForStudent(@RequestBody StudentDTO dto) {
        Student student = studentService.findStudentAndCoursesByStudentId(dto.getId());

        for (CourseDTO course: dto.getCourses()) {
            Course dbCourse = courseService.findCourseById(course.getId());
            student.addCourse(dbCourse);
        }

        studentService.update(student);

        return student;
    }

    @DeleteMapping("students/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {
        Student student = studentService.findStudentAndCoursesByStudentId(studentId);

        if (student == null) {
            throw new RuntimeException("Student id not found - " + studentId);
        }

        studentService.deleteStudentById(studentId);

        return "Delete student id - " + studentId;
    }
}
