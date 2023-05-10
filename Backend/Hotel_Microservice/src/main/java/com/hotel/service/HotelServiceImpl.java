package com.hotel.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dto.HotelsDTO;
import com.hotel.entity.Hotels;
import com.hotel.exceptions.HotelException;
import com.hotel.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	HotelRepository hrepo;

	@Override
	public HotelsDTO addHotelsToDB(HotelsDTO hotelsDto) {
		Hotels hotelsEntity = hotelsDto.convertToEntity();
		int hotelId = hotelsEntity.getHotelId();
		Optional<Hotels> hotelFetchById = hrepo.findById(hotelId);
		if(hotelFetchById.isPresent()) {
			throw new HotelException("The Hotel is already Present");
		}
		hrepo.save(hotelsEntity);
		return hotelsEntity.convertToDTO();
	}

	@Override
	public List<HotelsDTO> fetchAllHotelsFromDB() {
		List<Hotels> hotelsList = hrepo.findAll();
		List<HotelsDTO> hotelsDtoList = hotelsList.stream().map(a -> a.convertToDTO()).collect(Collectors.toList());
		return hotelsDtoList;
	}

	@Override
	public HotelsDTO fetchSpecificHotelFromDB(int id) {
		Hotels hotelEntity = hrepo.findById(id).orElseThrow(() -> new HotelException("Hotel not Found!!!"));
		HotelsDTO hotelsDto = hotelEntity.convertToDTO();
		return hotelsDto;
	}

	@Transactional
	@Override
	public HotelsDTO updateSpecificHotelInDB(HotelsDTO hotelsDto) {
		Hotels hotelsEntity = hotelsDto.convertToEntity();
		Hotels hotelEntityFetchedFromDB = hrepo.findById(hotelsEntity.getHotelId()).orElseThrow(() -> new HotelException("Hotel not Found!!!"));
		hotelEntityFetchedFromDB.setHotelName(hotelsEntity.getHotelName());
		hotelEntityFetchedFromDB.setCity(hotelsEntity.getCity());
		return hotelEntityFetchedFromDB.convertToDTO();
	}

	@Override
	public HotelsDTO deleteSpecificHotelFromDB(int id) {
		Hotels hotelEntityFetchedFromDB = hrepo.findById(id).orElseThrow(() -> new HotelException("Hotel not Found!!!"));
		hrepo.deleteById(id);
		return hotelEntityFetchedFromDB.convertToDTO();
	}

}
