package com.sapient.bookshowsmgmt.service;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.bookshowsmgmt.dto.UserDTO;
import com.sapient.bookshowsmgmt.exception.UserNotFoundException;
import com.sapient.bookshowsmgmt.model.User;
import com.sapient.bookshowsmgmt.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper modelMapper;

	public List<UserDTO> findAllUsers() {
		Type listType = new TypeToken<List<UserDTO>>() {
		}.getType();
		List<UserDTO> userDtoList = modelMapper.map(userRepository.findAll(), listType);
		return userDtoList;
	}

	public User registerUser(UserDTO userDto) {
		User user = modelMapper.map(userDto, User.class);
		return userRepository.save(user);
	}

	public UserDTO findByUsername(String username) {
		User user = userRepository.findByUsername(username);
		return modelMapper.map(user, UserDTO.class);
	}

	public UserDTO findByUserId(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
		return modelMapper.map(user, UserDTO.class);
	}

}
