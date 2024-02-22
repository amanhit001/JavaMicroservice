package net.javaguides.springbootrestapi.service.UserService;

import java.util.List;

import net.javaguides.springbootrestapi.dto.UserDto;

public interface UserService {
	UserDto createUser(UserDto user);
	UserDto getUser(Long userId);
	List<UserDto> getAllUser();
	UserDto updateSpecificUser(UserDto user,Long Id);
	
	Boolean deleteUser(Long id);
	

}
