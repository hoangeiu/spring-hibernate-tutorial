package com.hoangle.udemy.service;

import com.hoangle.udemy.entity.Student;
import com.hoangle.udemy.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int theId) {
        return studentRepository.findStudentAndCoursesByStudentId(theId);
    }

    @Override
    public void update(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(int theId) {
        studentRepository.deleteById(theId);
    }
}
