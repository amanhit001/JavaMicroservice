package net.javaguides.springbootrestapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import net.javaguides.springbootrestapi.dto.UserDto;
import net.javaguides.springbootrestapi.entity.User;

@Mapper
public interface AutoUserMapper {
	//This Interface will define methods that can be used to convert 
	//Dto class into Jpa entity or vice versa
	//Fields name should be same if not then 
	// we need to provide through @Mapping(source="email",target="emailAddress")
	
	AutoUserMapper mapper= Mappers.getMapper(AutoUserMapper.class);
	//Mappers.getMapper this method returns the object of this inteface which can be returned
	//at compile time and used to call these two methods.
	
	UserDto mapToUserDto(User user);
	User mapToUser(UserDto userDto);
}
