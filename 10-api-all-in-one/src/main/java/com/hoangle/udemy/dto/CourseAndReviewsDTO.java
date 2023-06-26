package com.hoangle.udemy.dto;

import com.hoangle.udemy.entity.Review;

import java.util.List;

public class CourseAndReviewsDTO {
    private int id;

    private String title;

    private List<Review> reviews;

    public CourseAndReviewsDTO() {
    }

    public CourseAndReviewsDTO(int id, String title, List<Review> reviews) {
        this.id = id;
        this.title = title;
        this.reviews = reviews;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
