package com.hoangle.udemy.service;

import com.hoangle.udemy.entity.Course;
import com.hoangle.udemy.entity.Instructor;
import com.hoangle.udemy.entity.InstructorDetail;
import com.hoangle.udemy.repository.InstructorDetailRepository;
import com.hoangle.udemy.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {
    private InstructorRepository instructorRepository;
    private InstructorDetailRepository instructorDetailRepository;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository, InstructorDetailRepository instructorDetailRepository) {
        this.instructorRepository = instructorRepository;
        this.instructorDetailRepository = instructorDetailRepository;
    }


    @Override
    public Instructor saveInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        Optional<Instructor> result = instructorRepository.findById(theId);

        Instructor instructor = null;
        if (result.isPresent()) {
            instructor = result.get();
        } else {
            throw new RuntimeException("Did not found instructor id - " + theId);
        }

        return instructor;
    }

    @Override
    public void deleteInstructorById(int theId) {
        Optional<Instructor> result = instructorRepository.findById(theId);

        if(result.isPresent()) {
            Instructor instructor = result.get();
            List<Course> courses = instructor.getCourses();
            for (Course course: courses) {
                course.setInstructor(null);
            }
        }

        instructorRepository.deleteById(theId);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        Optional<InstructorDetail> result = instructorDetailRepository.findById(theId);

        InstructorDetail instructorDetail = null;
        if (result.isPresent()) {
            instructorDetail = result.get();
        } else {
            throw new RuntimeException("Did not found instructor detail id - " + theId);
        }

        return instructorDetail;
    }

    @Override
    public void deleteInstructorDetailById(int theId) {
        Optional<InstructorDetail> result = instructorDetailRepository.findById(theId);

        if (result.isPresent()) {
            InstructorDetail instructorDetail = result.get();
            instructorDetail.getInstructor().setInstructorDetail(null);;
        }

        instructorDetailRepository.deleteById(theId);
    }
}
