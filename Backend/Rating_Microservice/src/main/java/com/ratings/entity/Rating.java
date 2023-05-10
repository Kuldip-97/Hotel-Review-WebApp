package com.ratings.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.ratings.dto.RatingDTO;

@Entity
public class Rating {
	@Id
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
	
	
	public Rating(int id, int likes, String review) {
		this.id = id;
		this.likes = likes;
		this.review = review;
	}
	public Rating() {}
	
	
	public RatingDTO convertToDTO() {
		RatingDTO ratingdto = new RatingDTO(this.getId(), this.getLikes(), this.getReview());
		ratingdto.setId(this.getId());
		ratingdto.setLikes(this.getLikes());
		ratingdto.setReview(this.getReview());
		return ratingdto;
	}
}
