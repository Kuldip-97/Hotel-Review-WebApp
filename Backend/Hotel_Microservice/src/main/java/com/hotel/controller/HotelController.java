package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.dto.HotelsDTO;
import com.hotel.service.HotelService;

@CrossOrigin("http://localhost:4200/")
@RestController
public class HotelController {
	@Autowired
	HotelService hser;
	
	
	@PostMapping("/hotels")
	public ResponseEntity<HotelsDTO> addHotel(@RequestBody HotelsDTO hotelsDto){
		return new ResponseEntity<HotelsDTO>(hser.addHotelsToDB(hotelsDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/hotels")
	public ResponseEntity<List<HotelsDTO>> getHotels(){
		return new ResponseEntity<>(hser.fetchAllHotelsFromDB(), HttpStatus.OK);
	}
	
	@GetMapping("/hotels/{id}")
	public ResponseEntity<HotelsDTO> getSpecificHotel(@PathVariable int id){
		return new ResponseEntity<>(hser.fetchSpecificHotelFromDB(id), HttpStatus.OK);
	}
	
	@PutMapping("/hotels")
	public ResponseEntity<HotelsDTO> updateHotels(@RequestBody HotelsDTO hotelsDto){
		return new ResponseEntity<>(hser.updateSpecificHotelInDB(hotelsDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/hotels/{id}")
	public ResponseEntity<HotelsDTO> deleteSpecificHotel(@PathVariable int id){
		return new ResponseEntity<>(hser.deleteSpecificHotelFromDB(id), HttpStatus.OK);
	}
}
