package com.hoangeiu.REST.CRUD.APIs.rest;

import com.hoangeiu.REST.CRUD.APIs.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Hoang", "Le"));
        theStudents.add(new Student("Mai", "Nguyen"));
        theStudents.add(new Student("Ngoc", "Tran"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    // PathVariable must be the same as url studentId = studentId
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if (studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);
    }
}
