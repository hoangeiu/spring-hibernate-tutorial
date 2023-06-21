package com.hoangle.crud;

import com.hoangle.crud.dao.InstructorDAO;
import com.hoangle.crud.entity.Course;
import com.hoangle.crud.entity.Instructor;
import com.hoangle.crud.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorDAO instructorDAO) {
		return runner -> {
//			createInstructor(instructorDAO);
//			findInstructor(instructorDAO);
//			deleteInstructor(instructorDAO);
//			findInstructorDetail(instructorDAO);
//			deleteInstructorDetail(instructorDAO);
			createInstructorWithCourses(instructorDAO);
		};
	}

	private void createInstructorWithCourses(InstructorDAO instructorDAO) {
		Instructor instructor = new Instructor("Hoang", "Le", "hoang@le.com");

		InstructorDetail instructorDetail = new InstructorDetail("http://youtube.com", "Reading");

		instructor.setInstructorDetail(instructorDetail);

		// create some courses
		Course course1 = new Course("Alice in BorderLand");
		Course course2 = new Course("Quiet");

		instructor.add(course1);
		instructor.add(course2);

		// save the instructor
		// NOTe: this will ALSO save the details object, courses object
		// because of CascadeType.PERSIST
		System.out.println("Saving instructor: " + instructor);
		System.out.println("The courses: " + instructor.getCourses());
		instructorDAO.save(instructor);
		System.out.println("DONE!");
	}

	private void deleteInstructorDetail(InstructorDAO instructorDAO) {
		int theId = 3;
		System.out.println("Deleting instructor detail id: " + theId);
		instructorDAO.deleteInstructorDetailById(theId);
		System.out.println("DONE!");
	}

	private void findInstructorDetail(InstructorDAO instructorDAO) {
		int theId = 1;
		System.out.println("Finding instructor detail id: " + theId);
		InstructorDetail instructorDetail = instructorDAO.findInstructorDetailById(theId);
		System.out.println("Instructor detail: " + instructorDetail);
		System.out.println("The associated instructor: " + instructorDetail.getInstructor());
	}

	private void deleteInstructor(InstructorDAO instructorDAO) {
		int theId = 2;
		System.out.println("Deleting instructor id: " + theId);
		instructorDAO.deleteInstructorById(theId);
		System.out.println("DONE!");
	}

	private void findInstructor(InstructorDAO instructorDAO) {
		int theId = 2;
		System.out.println("Finding instructor id: " + theId);
		Instructor instructor = instructorDAO.findInstructorById(theId);
		System.out.println("Instructor: " + instructor);
		System.out.println("Instructor detail only: " + instructor.getInstructorDetail());
	}

	private void createInstructor(InstructorDAO instructorDAO) {
		Instructor instructor = new Instructor("Hoang", "Le", "hoang@le.com");

		InstructorDetail instructorDetail = new InstructorDetail("http://youtube.com", "Reading");

		instructor.setInstructorDetail(instructorDetail);

		// save the instructor
		// NOTe: this will ALSO save the details object
		// because of CascadeType.ALL
		System.out.println("Saving instructor: " + instructor);
		instructorDAO.save(instructor);
		System.out.println("DONE!");
	}

}
