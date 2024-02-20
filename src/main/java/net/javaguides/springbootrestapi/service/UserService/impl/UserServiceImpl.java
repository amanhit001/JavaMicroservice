package net.javaguides.springbootrestapi.service.UserService.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.springbootrestapi.entity.User;
import net.javaguides.springbootrestapi.repository.UserRepository;
import net.javaguides.springbootrestapi.service.UserService.UserService;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public User getUser(Long userId) {
		Optional<User> optionalUser =userRepository.findById(userId);
		return optionalUser.get();
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	@Override
	public User updateSpecificUser(User user,Long Id)
	{
		User updateduser=userRepository.findById(Id).get();;
		
		updateduser.setFirstName(user.getFirstName());
		updateduser.setLastName(user.getLastName());
		updateduser.setEmail(user.getEmail());
		
		return userRepository.save(updateduser);
	}

	@Override
	public Boolean deleteUser(Long id) {
		userRepository.deleteById(id);
		return true;
	}

}
