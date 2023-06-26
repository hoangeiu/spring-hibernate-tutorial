package com.hoangle.udemy.dto;

public class InstructorWithInstructorDetailDTO {
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String youtubeChannel;

    private String hobby;

    public InstructorWithInstructorDetailDTO() {
    }

    public InstructorWithInstructorDetailDTO(String firstName, String lastName, String email, String youtubeChannel, String hobby) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
