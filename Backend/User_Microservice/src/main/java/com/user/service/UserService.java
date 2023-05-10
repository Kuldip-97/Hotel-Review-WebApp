package com.user.service;

import java.util.List;

import com.user.dto.UserDTO;

public interface UserService {

	UserDTO addUserDataToDB(UserDTO userdto);

	List<UserDTO> getAllUsersFromDB();

	UserDTO getSpecificUserFromDB(int userId);

	UserDTO updateSpecificUserInDB(UserDTO userdto);

	UserDTO deleteSpecificUserFromDB(int userId);

}
