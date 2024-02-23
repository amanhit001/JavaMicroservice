package net.javaguides.springbootrestapi.service.UserService.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.springbootrestapi.dto.UserDto;
import net.javaguides.springbootrestapi.entity.User;
import net.javaguides.springbootrestapi.exception.ResourceNotFoundException;
import net.javaguides.springbootrestapi.mapper.AutoUserMapper;
import net.javaguides.springbootrestapi.repository.UserRepository;
import net.javaguides.springbootrestapi.service.UserService.UserService;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		//Convert the UserDto into User
		
		// 1. User user=UserMapper.mapToUser(userDto);
		
		
		
		// 2. User user = modelMapper.map(userDto, User.class);
		//3.
		
		User user = AutoUserMapper.mapper.mapToUser(userDto);
		
		User savedUser = userRepository.save(user);
		
		//convert the User into userDto
		
		// 1. UserDto uDto=UserMapper.mapToUserDto(savedUser);
		// 2. UserDto uDto=modelMapper.map(savedUser,UserDto.class);
		// 3.
		
		UserDto uDto =AutoUserMapper.mapper.mapToUserDto(savedUser);
		
		return uDto;
	}

	@Override
	public UserDto getUser(Long userId) {
		User user =userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User","id",userId)
				);
				
		
		
		// 1. return UserMapper.mapToUserDto(user);
		// 2. return modelMapper.map(user, UserDto.class);
		// 3.
		return AutoUserMapper.mapper.mapToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users =userRepository.findAll();
		// 1. return users.stream().map(UserMapper::mapToUserDto)
		//		.collect(Collectors.toList());
		
		/* 2.
		 * return users.stream().map((user) -> modelMapper.map(user,UserDto.class))
		 * .collect(Collectors.toList());
		 */
		
		// 3.
		return users.stream().map((user) -> AutoUserMapper.mapper.mapToUserDto(user))
				.collect(Collectors.toList());
	}
	
	@Override
	public UserDto updateSpecificUser(UserDto user,Long Id)
	{
		User toBeUpdateUser=userRepository.findById(Id).orElseThrow(
				() -> new ResourceNotFoundException("User","id",user.getId())
				);
		
		toBeUpdateUser.setFirstName(user.getFirstName());
		toBeUpdateUser.setLastName(user.getLastName());
		toBeUpdateUser.setEmail(user.getEmail());
		
		
		User updatedUser = userRepository.save(toBeUpdateUser);
		
		// 1. return UserMapper.mapToUserDto(updatedUser);
		// 2. return modelMapper.map(updatedUser,UserDto.class);
		// 3.
		return AutoUserMapper.mapper.mapToUserDto(updatedUser);
	}

	@Override
	public void deleteUser(Long id) {
		
		User existingUser= userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("User","id",id)
				); 
		userRepository.deleteById(id);
		
	}

}
