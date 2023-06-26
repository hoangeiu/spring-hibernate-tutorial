package com.hoangle.udemy.rest;

import com.hoangle.udemy.dto.InstructorWithCoursesDTO;
import com.hoangle.udemy.entity.Course;
import com.hoangle.udemy.entity.Instructor;
import com.hoangle.udemy.entity.InstructorDetail;
import com.hoangle.udemy.service.CourseService;
import com.hoangle.udemy.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorRestController {
    private InstructorService instructorService;
    private CourseService courseService;

    @Autowired
    public InstructorRestController(InstructorService instructorService, CourseService courseService) {
        this.instructorService = instructorService;
        this.courseService = courseService;
    }




    @PostMapping("/instructors")
    public Instructor addInstructor(@RequestBody InstructorWithCoursesDTO dto) {
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        Instructor instructor = new Instructor(dto.getFirstName(), dto.getFirstName(), dto.getEmail());

        InstructorDetail instructorDetail = new InstructorDetail(dto.getYoutubeChannel(), dto.getHobby());

        for (String title: dto.getCourseTitles()) {
            instructor.addCourse(new Course(title));
        }

        instructor.setInstructorDetail(instructorDetail);

        Instructor dbInstructor = instructorService.saveInstructor(instructor);

        return dbInstructor;
    }

    @GetMapping("/instructors/{instructorId}")
    public Instructor getInstructor(@PathVariable int instructorId) {
        Instructor instructor = instructorService.findInstructorById(instructorId);

        return instructor;
    }

    @DeleteMapping("/instructors/{instructorId}")
    public String deleteInstructor(@PathVariable int instructorId) {
        Instructor instructor = instructorService.findInstructorById(instructorId);

        if (instructor == null) {
            throw new RuntimeException("Instructor id not found - " + instructorId);
        }

        instructorService.deleteInstructorById(instructorId);

        return "Delete instructor id - " + instructorId;
    }

    @GetMapping("/instructor-details/{instructorDetailId}")
    public InstructorDetail getInstructorDetail(@PathVariable int instructorDetailId) {
        InstructorDetail instructorDetail = instructorService.findInstructorDetailById(instructorDetailId);

        return instructorDetail;
    }

    @DeleteMapping("/instructor-details/{instructorDetailId}")
    public String deleteInstructorDetail(@PathVariable int instructorDetailId) {
        InstructorDetail instructorDetail = instructorService.findInstructorDetailById(instructorDetailId);

        if (instructorDetail == null) {
            throw new RuntimeException("Instructor detail id not found - " + instructorDetailId);
        }

        instructorService.deleteInstructorDetailById(instructorDetailId);

        return "Delete instructor detail id - " + instructorDetailId;
    }

    @PutMapping("/instructors")
    public Instructor updateInstructor(@RequestBody Instructor instructor) {
        Instructor dbInstructor = instructorService.findInstructorById(instructor.getId());
        dbInstructor.setFirstName(instructor.getFirstName());
        dbInstructor.setLastName(instructor.getLastName());
        dbInstructor.setEmail(instructor.getEmail());

        Instructor savedInstructor = instructorService.saveInstructor(dbInstructor);

        return savedInstructor;
    }


}
