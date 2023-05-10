package com.ratings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ratings.dto.RatingDTO;
import com.ratings.service.RatingService;

@RestController
public class RatingController {
	@Autowired
	RatingService rser;
	
	@PostMapping("/rating")
	public ResponseEntity<RatingDTO> addRating(@RequestBody RatingDTO rdto){
		return new ResponseEntity<RatingDTO>(rser.addRatingToDB(rdto), HttpStatus.OK);
	}
	
	@GetMapping("/rating")
	public ResponseEntity<List<RatingDTO>> showRating(){
		return new ResponseEntity<List<RatingDTO>>(rser.showAllRatingsFromDB(), HttpStatus.OK);
	}
	
	@GetMapping("/rating/{id}")
	public ResponseEntity<RatingDTO> showSpecificRating(@PathVariable int id){
		return new ResponseEntity<RatingDTO>(rser.showSpecificRatingFormDB(id), HttpStatus.OK);
	}
	
	@PutMapping("/rating")
	public ResponseEntity<RatingDTO> updateSpecificRating(@RequestBody RatingDTO rdto){
		return new ResponseEntity<RatingDTO>(rser.updateSpecificRatingFromDB(rdto), HttpStatus.OK);
	}
	
	@DeleteMapping("/rating/{id}")
	public ResponseEntity<RatingDTO> deleteSpecificRating(@PathVariable int id){
		return new ResponseEntity<RatingDTO>(rser.deleteSpecificRatingFromDB(id), HttpStatus.OK);
	}
}
