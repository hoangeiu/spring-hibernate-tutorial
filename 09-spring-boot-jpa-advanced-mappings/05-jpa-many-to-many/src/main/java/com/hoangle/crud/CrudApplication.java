package com.hoangle.crud;

import com.hoangle.crud.dao.InstructorDAO;
import com.hoangle.crud.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
//			createInstructorWithCourses(instructorDAO);
//			findInstructorWithCourses(instructorDAO);
//			findCoursesForInstructor(instructorDAO);
//			findInstructorWithCoursesJoinFetch(instructorDAO);
//			updateInstructor(instructorDAO);
//			updateCourse(instructorDAO);
//			deleteCourse(instructorDAO);
//			createCourseAndReviews(instructorDAO);
//			retrieveCourseAndReviews(instructorDAO);
//			deleteCourseAndReviews(instructorDAO);
//			createCourseAndStudents(instructorDAO);
//			findCourseAndStudents(instructorDAO);
//			findStudentAndCourses(instructorDAO);
//			addMoreCoursesForStudent(instructorDAO);
			deleteStudent(instructorDAO);
		};

	}

	private void deleteStudent(InstructorDAO instructorDAO) {
		int theId = 2;
		System.out.println("Deleting student id: " + theId);

		instructorDAO.deleteStudentById(theId);

		System.out.println("DONE!");
	}

	private void addMoreCoursesForStudent(InstructorDAO instructorDAO) {
		int theId = 2;
		Student student = instructorDAO.findStudentAndCoursesByStudentId(theId);

		Course course1 = new Course("Bored to find a new job");
		Course course2 = new Course("Because you old");

		student.addCourse(course1);
		student.addCourse(course2);

		System.out.println("Updating student: " + student);
		System.out.println("Associated courses: " + student.getCourses());

		instructorDAO.update(student);

		System.out.println("DONE!");
	}

	private void findStudentAndCourses(InstructorDAO instructorDAO) {
		int theId = 1;
		Student student = instructorDAO.findStudentAndCoursesByStudentId(theId);

		System.out.println("Loaded student: " + student);
		System.out.println("Courses: " + student.getCourses());

		System.out.println("DONE!");
	}

	private void findCourseAndStudents(InstructorDAO instructorDAO) {
		int theId = 10;
		Course course = instructorDAO.findCourseAndStudentsByCourseId(theId);

		System.out.println("Loaded course: " + course);
		System.out.println("Students: " + course.getStudents());

		System.out.println("DONE!");
	}

	private void createCourseAndStudents(InstructorDAO instructorDAO) {
		Course course = new Course("How to live in Vietnam");

		Student student1 = new Student("Long", "Le", "long@le.test");
		Student student2 = new Student("Hanh", "Ho", "hanh@ho.test");
		Student student3 = new Student("Dinh", "Doan", "dinh@doan.test");

		course.addStudent(student1);
		course.addStudent(student2);
		course.addStudent(student3);

		// save the course and associated students
		System.out.println("Saving the course: " + course);
		System.out.println("Associated students " + course.getStudents());

		instructorDAO.save(course);

		System.out.println("DONE!");
	}

	private void deleteCourseAndReviews(InstructorDAO instructorDAO) {
		int theId = 10;

		System.out.println("Deleting course id: " + theId);

		instructorDAO.deleteCourseById(theId);

		System.out.println("DONE!");
	}

	private void retrieveCourseAndReviews(InstructorDAO instructorDAO) {
		int theId = 10;

		Course course = instructorDAO.findCourseAndReviewsByCourseId(theId);

		System.out.println(course);

		System.out.println(course.getReviews());

		System.out.println("DONE!");
	}

	private void createCourseAndReviews(InstructorDAO instructorDAO) {
		Course course = new Course("Java - Beginner Course");

		course.addReview(new Review("Just a normal course"));
		course.addReview(new Review("Many duplicate content"));
		course.addReview(new Review("Suitable for beginner like me"));

		// save the course and leverage the cascade all
		System.out.println("Saving the course");
		System.out.println(course);
		System.out.println(course.getReviews());

		instructorDAO.save(course);

		System.out.println("DONE!");
	}

	private void deleteCourse(InstructorDAO instructorDAO) {
		int theId = 10;
		System.out.println("Deleting course id: " + theId);
		instructorDAO.deleteCourseById(theId);
		System.out.println("DONE!");
	}

	private void updateCourse(InstructorDAO instructorDAO) {
		int theId = 11;

		System.out.println("Finding course id: " + theId);
		Course course = instructorDAO.findCourseById(theId);

		// update the course
		System.out.println("Updating course id: " + theId);
		course.setTitle("Doremon");

		instructorDAO.update(course);

		System.out.println("DONE!");
	}

	private void updateInstructor(InstructorDAO instructorDAO) {
		int theId = 1;

		System.out.println("Finding instructor id: " + theId);
		Instructor instructor = instructorDAO.findInstructorById(theId);

		// update the instructor
		System.out.println("Updating instructor id: " + theId);
		instructor.setLastName("Lê Minh");

		instructorDAO.update(instructor);

		System.out.println("DONE!");
	}

	private void findInstructorWithCoursesJoinFetch(InstructorDAO instructorDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor instructor = instructorDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("Instructor: " + instructor);

		System.out.println("The associated courses: " + instructor.getCourses());

		System.out.println("DONE!");
	}

	private void findCoursesForInstructor(InstructorDAO instructorDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor instructor = instructorDAO.findInstructorById(theId);

		System.out.println("Instructor: " + instructor);

		// find courses for instructor
		System.out.println("Finding courses for instructor id: " + theId);
		List<Course> courses = instructorDAO.findCoursesByInstructorId(theId);

		instructor.setCourses(courses);

		System.out.println("The associated courses: " + instructor.getCourses());

		System.out.println("DONE!");
	}

	private void findInstructorWithCourses(InstructorDAO instructorDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor instructor = instructorDAO.findInstructorById(theId);

		System.out.println("Instructor: " + instructor);
		System.out.println("The associated courses: " + instructor.getCourses());

		System.out.println("DONE!");
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
		int theId = 1;
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
