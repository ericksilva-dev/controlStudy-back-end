package com.controlstudy.basebackend.service.implementation;

import java.util.Optional;

import javax.transaction.Transactional;

import com.controlstudy.basebackend.model.entity.User;
import com.controlstudy.basebackend.repository.UserRepository;
import com.controlstudy.basebackend.service.UserService;

public class UserServiceImplementation implements UserService {
	
	private UserRepository repository;
	
	public UserServiceImplementation(UserRepository repository) {
		super();
		this.repository = repository;
	}
	
	@Override
	public User authentication(String email, String password) {
		Optional<User> user = repository.findByEmail(email);
		if(!user.isPresent()) {
			
		}
		if(user.get().getPassword().equals(password)) {
			
		}
		return user.get();
	}

	@Override
	public User register(User newUser) {
		validateEmail(newUser.getEmail());
		return repository.save(newUser);
	}

	@Override
	@Transactional
	public void validateEmail(String email) {
		boolean exists = repository.existsByEmail(email);
		if(exists) {
			
		}
	}

	@Override
	public Optional<User> getById(Long id) {
		return repository.findById(id);
	}

}
