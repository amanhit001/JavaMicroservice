package net.javaguides.springbootrestapi.service.UserService;

import java.util.List;

import net.javaguides.springbootrestapi.entity.User;

public interface UserService {
	User createUser(User user);
	User getUser(Long userId);
	List<User> getAllUser();
	User updateSpecificUser(User user,Long Id);
	
	Boolean deleteUser(Long id);
	

}
