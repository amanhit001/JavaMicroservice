package net.javaguides.springbootrestapi.service.UserService.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.springbootrestapi.dto.UserDto;
import net.javaguides.springbootrestapi.entity.User;
import net.javaguides.springbootrestapi.mapper.UserMapper;
import net.javaguides.springbootrestapi.repository.UserRepository;
import net.javaguides.springbootrestapi.service.UserService.UserService;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto userDto) {
		//Convert the UserDto into User
		
		User user=UserMapper.mapToUser(userDto);
		
		User savedUser = userRepository.save(user);
		
		//convert the User into userDto
		
		UserDto uDto=UserMapper.mapToUserDto(savedUser);
		
		return uDto;
	}

	@Override
	public UserDto getUser(Long userId) {
		Optional<User> optionalUser =userRepository.findById(userId);
		User user=optionalUser.get();
		return UserMapper.mapToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users =userRepository.findAll();
		return users.stream().map(UserMapper::mapToUserDto)
				.collect(Collectors.toList());
	}
	
	@Override
	public UserDto updateSpecificUser(UserDto user,Long Id)
	{
		User toBeUpdateUser=userRepository.findById(Id).get();;
		
		toBeUpdateUser.setFirstName(user.getFirstName());
		toBeUpdateUser.setLastName(user.getLastName());
		toBeUpdateUser.setEmail(user.getEmail());
		
		
		User updatedUser = userRepository.save(toBeUpdateUser);
		
		return UserMapper.mapToUserDto(updatedUser);
	}

	@Override
	public Boolean deleteUser(Long id) {
		userRepository.deleteById(id);
		return true;
	}

}
