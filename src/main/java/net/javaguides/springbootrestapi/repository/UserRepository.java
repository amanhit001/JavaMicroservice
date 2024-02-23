package net.javaguides.springbootrestapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springbootrestapi.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{
	
	//Custom query method to check email id 
	
	Optional<User> findByEmail(String email);

}
