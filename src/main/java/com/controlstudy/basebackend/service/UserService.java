package com.controlstudy.basebackend.service;

import java.util.Optional;

import com.controlstudy.basebackend.model.entity.User;

public interface UserService {
	
	User authentication(String email, String password);
	
	User register(User newUser);
	
	void validateEmail(String email);
	
	Optional<User> getById(Long id);
}
