package com.hotel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.hotel.dto.HotelsDTO;

@Entity
public class Hotels {
	@Id
	private int hotelId;
	private String hotelName;
	private String city;
	
	
	//Getters and Setters
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	//Constructors
	public Hotels(int hotelId, String hotelName, String city) {
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.city = city;
	}
	public Hotels() {}
	//Converter
	public HotelsDTO convertToDTO() {
		HotelsDTO hotelDto = new HotelsDTO(this.getHotelId(), this.getHotelName(), this.getCity());
		return hotelDto;
	}
}
