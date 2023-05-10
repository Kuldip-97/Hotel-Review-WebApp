package com.ratings.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratings.dto.RatingDTO;
import com.ratings.entity.Rating;
import com.ratings.exception.RatingException;
import com.ratings.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {
	@Autowired
	RatingRepository rrepo;

	@Override
	public RatingDTO addRatingToDB(RatingDTO rdto) {
		Optional<Rating> optionalRating = rrepo.findById(rdto.getId());
		if(optionalRating.isPresent()) {
			throw new RatingException("Rating is Already Done");
		}
		Rating ratingEntity = rdto.convertToEntity();
		rrepo.save(ratingEntity);
		RatingDTO ratingDtoConverted = ratingEntity.convertToDTO();
		return ratingDtoConverted;
	}

	@Override
	public List<RatingDTO> showAllRatingsFromDB() {
		List<Rating> ratingEntityList = rrepo.findAll();
		List<RatingDTO> ratingDtoList = ratingEntityList.stream().map((a) -> a.convertToDTO()).collect(Collectors.toList());
		return ratingDtoList;
	}

	@Override
	public RatingDTO showSpecificRatingFormDB(int id) {
		Rating ratingEntity = rrepo.findById(id).orElseThrow(() -> new RatingException("Rating not Found!!!"));
		RatingDTO ratingDto = ratingEntity.convertToDTO();
		return ratingDto;
	}
	
	@Transactional
	@Override
	public RatingDTO updateSpecificRatingFromDB(RatingDTO rdto) {
		Rating ratingEntity = rrepo.findById(rdto.getId()).orElseThrow(() -> new RatingException("Rating not Found!!!"));
		ratingEntity.setId(rdto.getId());
		ratingEntity.setLikes(rdto.getLikes());
		ratingEntity.setReview(rdto.getReview());
		RatingDTO ratingDtoConverted = ratingEntity.convertToDTO();
		return ratingDtoConverted;
	}

	@Override
	public RatingDTO deleteSpecificRatingFromDB(int id) {
		Rating ratingEntity = rrepo.findById(id).orElseThrow(() -> new RatingException("Rating not Found!!!"));
		rrepo.deleteById(ratingEntity.getId());
		RatingDTO rdtoConverted = ratingEntity.convertToDTO();
		return rdtoConverted;
	}
}
