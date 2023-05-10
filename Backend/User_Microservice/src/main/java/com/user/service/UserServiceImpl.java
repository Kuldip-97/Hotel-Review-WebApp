package com.user.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dto.UserDTO;
import com.user.entity.User;
import com.user.exception.UserException;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository urep;
	
	@Override
	public UserDTO addUserDataToDB(UserDTO userdto) {
		User userEntity = userdto.convertToEntity();
		Optional<User> optionalUserEntity = urep.findById(userEntity.getId());
		if(optionalUserEntity.isPresent()) {
			throw new UserException("User is already Present!!!");
		}
		urep.save(userEntity);
		UserDTO userDtoConverted = userEntity.convertToDTO();
		return userDtoConverted;
	}

	@Override
	public List<UserDTO> getAllUsersFromDB() {
		List<User> userEntityList = urep.findAll();
		List<UserDTO> userDtoList = userEntityList.stream().map( (a)-> a.convertToDTO()).collect(Collectors.toList());
		return userDtoList;
	}

	@Override
	public UserDTO getSpecificUserFromDB(int userId) {
		User userEntity = urep.findById(userId).orElseThrow(() -> new UserException("User not Found!!!"));
		UserDTO userDto = userEntity.convertToDTO();
		return userDto;
	}
	
	@Transactional
	@Override
	public UserDTO updateSpecificUserInDB(UserDTO userdto) {
		User userEntityById = urep.findById(userdto.getId()).orElseThrow(() -> new UserException("User not Found!!!"));
		userEntityById.setName(userdto.getName());
		userEntityById.setEmail(userdto.getEmail());
		UserDTO userDtoConverted = userEntityById.convertToDTO();
		return userDtoConverted;
	}

	@Override
	public UserDTO deleteSpecificUserFromDB(int userId) {
		User userEntityById = urep.findById(userId).orElseThrow(() -> new UserException("User not Found!!!"));
		urep.deleteById(userId);
		UserDTO userDto = userEntityById.convertToDTO();
		return userDto;
	}
}
