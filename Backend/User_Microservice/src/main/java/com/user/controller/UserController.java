package com.user.controller;

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

import com.user.dto.UserDTO;
import com.user.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userv;
	
	@PostMapping("/user")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userdto){
		return new ResponseEntity<UserDTO>(userv.addUserDataToDB(userdto), HttpStatus.OK);
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		return new ResponseEntity<List<UserDTO>>(userv.getAllUsersFromDB(),HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<UserDTO> getSpecificUser(@PathVariable int userId){
		return new ResponseEntity<UserDTO>(userv.getSpecificUserFromDB(userId), HttpStatus.OK);
	}
	
	@PutMapping("/user")
	public ResponseEntity<UserDTO> updateUserInDB(@RequestBody UserDTO userdto){
		return new ResponseEntity<UserDTO>(userv.updateSpecificUserInDB(userdto), HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<UserDTO> deleteUserFromDB(@PathVariable int userId){
		return new ResponseEntity<UserDTO>(userv.deleteSpecificUserFromDB(userId), HttpStatus.OK);
	}
}
