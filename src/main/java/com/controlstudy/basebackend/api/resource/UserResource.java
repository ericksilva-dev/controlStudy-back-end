package com.controlstudy.basebackend.api.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlstudy.basebackend.api.dto.UserDTO;
import com.controlstudy.basebackend.exception.ErrorBuilder;
import com.controlstudy.basebackend.exception.MessageBuilder;
import com.controlstudy.basebackend.model.entity.User;
import com.controlstudy.basebackend.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserResource {
	
	private UserService serviceUser;
	
	public UserResource(UserService serviceUser) {
		this.serviceUser = serviceUser;
	}
	
	@PostMapping("/signUp")
	public ResponseEntity registerUser( @RequestBody UserDTO userDto) {
		User registeredUser = new User(userDto.getName(), userDto.getEmail(), userDto.getPassword());
		try {
			User userSave = serviceUser.register(registeredUser);
			return new ResponseEntity(userSave, HttpStatus.CREATED);
		} catch (MessageBuilder e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping("/signIn") 
	public ResponseEntity authenticationUser( @RequestBody UserDTO userDto) {
		try {
			User userAuthentication = serviceUser.authentication(userDto.getEmail(), userDto.getPassword());
			return ResponseEntity.ok(userAuthentication);
		} catch (ErrorBuilder e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
