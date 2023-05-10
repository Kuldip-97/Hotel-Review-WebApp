package com.user.dto;

import com.user.entity.User;

public class UserDTO {
	private int id;
	private String name;
	private String email;
	
	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//Constructors
	public UserDTO(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public UserDTO() {}
	
	
	//Converters
	public User convertToEntity() {
		User user = new User(this.getId(), this.getName(), this.getEmail());
		return user;
	}
}
