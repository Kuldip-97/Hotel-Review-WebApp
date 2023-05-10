package com.hotel.service;

import java.util.List;

import com.hotel.dto.HotelsDTO;

public interface HotelService {

	HotelsDTO addHotelsToDB(HotelsDTO hotelsDto);

	List<HotelsDTO> fetchAllHotelsFromDB();

	HotelsDTO fetchSpecificHotelFromDB(int id);

	HotelsDTO updateSpecificHotelInDB(HotelsDTO hotelsDto);

	HotelsDTO deleteSpecificHotelFromDB(int id);
	
}
