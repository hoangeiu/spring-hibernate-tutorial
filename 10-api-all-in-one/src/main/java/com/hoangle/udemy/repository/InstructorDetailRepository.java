package com.hoangle.udemy.repository;

import com.hoangle.udemy.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Integer> {
}
