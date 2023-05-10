package com.user.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.user.dto.UserDTO;

@Entity
@Table(name = "UserDetails")
public class User {
	@Id
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
	public User(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public User() {}
	
	//Converters
	public UserDTO convertToDTO() {
		UserDTO uDto = new UserDTO(this.getId(), this.getName(), this.getEmail());
		return uDto;
	}
}
