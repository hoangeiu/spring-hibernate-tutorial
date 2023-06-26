package com.hoangle.udemy.dto;

import java.util.List;

public class InstructorWithCoursesDTO extends InstructorWithInstructorDetailDTO{
    private List<String> courseTitles;

    public InstructorWithCoursesDTO() {
    }

    public InstructorWithCoursesDTO(String firstName, String lastName, String email, String youtubeChannel, String hobby, List<String> courseTitles) {
        super(firstName, lastName, email, youtubeChannel, hobby);
        this.courseTitles = courseTitles;
    }

    public List<String> getCourseTitles() {
        return courseTitles;
    }

    public void setCourseTitles(List<String> courseTitles) {
        this.courseTitles = courseTitles;
    }
}
