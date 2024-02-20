package net.javaguides.springbootrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springbootrestapi.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
