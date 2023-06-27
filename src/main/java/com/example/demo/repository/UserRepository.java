package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User>findByEmailAndPassword(String email, String password);
	Optional<User>findByEmail(String email);
	
}
