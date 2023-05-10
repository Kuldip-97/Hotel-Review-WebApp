package com.hotel.dto;

import com.hotel.entity.Hotels;

public class HotelsDTO {
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
	
	
	//Constructor
	public HotelsDTO(int hotelId, String hotelName, String city) {
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.city = city;
	}
	public HotelsDTO() {}
	
	
	//Converter
	public Hotels convertToEntity() {
		Hotels hotels = new Hotels(this.getHotelId(), this.getHotelName(), this.getCity());
		return hotels;
	}
}
