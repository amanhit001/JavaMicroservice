package net.javaguides.springbootrestapi.mapper;

import net.javaguides.springbootrestapi.dto.UserDto;
import net.javaguides.springbootrestapi.entity.User;

public class UserMapper {
	
	//method to convert userDto to User
	public static User mapToUser(UserDto userDto)
	{
		User user = new User(
				userDto.getId(),
				userDto.getFirstName(),
				userDto.getLastName(),
				userDto.getEmail()
				);
		return user;
	}
	
	public static UserDto mapToUserDto(User user)
	{
		UserDto userDto = new UserDto(
				user.getId(),
				user.getFirstName(),
				user.getLastName(),
				user.getEmail()
				);
		return userDto;
	}

}
