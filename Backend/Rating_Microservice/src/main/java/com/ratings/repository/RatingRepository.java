package com.ratings.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ratings.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

}
