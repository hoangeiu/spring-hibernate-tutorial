package com.hoangle.udemy.rest;

import com.hoangle.udemy.dto.CourseAndReviewsDTO;
import com.hoangle.udemy.dto.CourseAndStudentsDTO;
import com.hoangle.udemy.dto.StudentDTO;
import com.hoangle.udemy.entity.Course;
import com.hoangle.udemy.entity.Review;
import com.hoangle.udemy.entity.Student;
import com.hoangle.udemy.service.CourseService;
import com.hoangle.udemy.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseRestController {
    private CourseService courseService;

    @Autowired
    public CourseRestController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses/{courseId}")
    public Course retrieveCourseAndReviews(@PathVariable int courseId) {
        Course course = courseService.findCourseById(courseId);

        return course;
    }

    @PostMapping("/course-reviews")
    public Course createCourseAndReviews(@RequestBody CourseAndReviewsDTO dto) {
        Course course = new Course(dto.getTitle());

        for (Review review: dto.getReviews()) {
            course.addReview(review);
        }

        return courseService.saveCourse(course);
    }

    @GetMapping("/course-students/{courseId}")
    public CourseAndStudentsDTO findCourseAndStudents(@PathVariable int courseId) {
        Course dbCourse = courseService.findCourseAndStudentsByCourseId(courseId);

        CourseAndStudentsDTO course = new CourseAndStudentsDTO();
        course.setId(dbCourse.getId());
        course.setTitle(dbCourse.getTitle());
        List<StudentDTO> students = new ArrayList<>();
        for (Student student: dbCourse.getStudents()) {
            StudentDTO dto = new StudentDTO();
            dto.setId(student.getId());
            dto.setFirstName(student.getFirstName());
            dto.setLastName(student.getLastName());
            dto.setEmail(student.getEmail());
            students.add(dto);
        }
        course.setStudents(students);

        return course;
    }

    @PostMapping("/course-students")
    public Course createCourseAndStudents(@RequestBody CourseAndStudentsDTO dto) {
        Course course = new Course((dto.getTitle()));

        for (StudentDTO student: dto.getStudents()) {
            course.addStudent(new Student(student.getFirstName(), student.getLastName(), student.getEmail()));
        }

        return courseService.saveCourse(course);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course) {
        Course dbCourse = courseService.findCourseById(course.getId());
        dbCourse.setTitle(course.getTitle());

        Course savedCourse = courseService.saveCourse(dbCourse);

        return savedCourse;
    }

    @DeleteMapping("/courses/{courseId}")
    public String deleteCourse(@PathVariable int courseId) {
        Course course = courseService.findCourseById(courseId);

        if (course == null) {
            throw new RuntimeException("Course id not found - " + courseId);
        }

        courseService.deleteCourseById(courseId);

        return "Delete course id - " + courseId;
    }
}
