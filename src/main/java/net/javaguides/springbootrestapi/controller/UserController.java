package net.javaguides.springbootrestapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.javaguides.springbootrestapi.entity.User;
import net.javaguides.springbootrestapi.service.UserService.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
	
	// http://localhost:8080/api/users
	private UserService userService;
	@PostMapping()
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User savedUser = userService.createUser(user);
		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Long Id)
	{
		User user= userService.getUser(Id);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUser()
	{
		List<User> us=userService.getAllUser();
		return new ResponseEntity<List<User>>(us,HttpStatus.OK);
	}
	
	//http://localhost:8080/api/users/update/2
	//SpringBoot Rest Api to update the user for specific id
	
	@PutMapping("/update/{userid}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable("userid") Long Id)
	{
		User updatedUser=userService.updateSpecificUser(user, Id);
		return new ResponseEntity<>(updatedUser,HttpStatus.OK);
	}
	//Spring Boot Rest API to delete a user
	//http://localhost:8080/api/users/delete/3
	
	@DeleteMapping("/delete/{userId}")
	public void deleteUser(@PathVariable("userId") Long id)
	{
		System.out.println(userService.deleteUser(id));
	}
	
	

}
