package com.ratings.service;

import java.util.List;

import com.ratings.dto.RatingDTO;

public interface RatingService {

	RatingDTO addRatingToDB(RatingDTO rdto);

	List<RatingDTO> showAllRatingsFromDB();

	RatingDTO showSpecificRatingFormDB(int id);

	RatingDTO updateSpecificRatingFromDB(RatingDTO rdto);

	RatingDTO deleteSpecificRatingFromDB(int id);
}
