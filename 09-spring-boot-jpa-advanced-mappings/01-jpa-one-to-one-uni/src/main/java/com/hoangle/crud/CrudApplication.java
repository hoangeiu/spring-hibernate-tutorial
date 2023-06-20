package com.hoangle.crud;

import com.hoangle.crud.dao.InstructorDAO;
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
			deleteInstructor(instructorDAO);
		};
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
		Instructor instructor = new Instructor("Susan", "Cain", "susan@cain.com");

		InstructorDetail instructorDetail = new InstructorDetail("http://youtube.com", "Writing book");

		instructor.setInstructorDetail(instructorDetail);

		// save the instructor
		// NOTe: this will ALSO save the details object
		// because of CascadeType.ALL
		System.out.println("Saving instructor: " + instructor);
		instructorDAO.save(instructor);
		System.out.println("DONE!");
	}

}
