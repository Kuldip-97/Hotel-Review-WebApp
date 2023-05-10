package com.ratings.dto;

import com.ratings.entity.Rating;

public class RatingDTO {
	private int id;
	private int likes;
	private String review;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
	
	public RatingDTO(int id, int likes, String review) {
		this.id = id;
		this.likes = likes;
		this.review = review;
	}
	public RatingDTO() {}
	
	
	public Rating convertToEntity() {
		Rating rating = new Rating(this.getId(), this.getLikes(), this.getReview());
		rating.setId(this.getId());
		rating.setLikes(this.getLikes());
		rating.setReview(this.getReview());
		return rating;
	}
}
