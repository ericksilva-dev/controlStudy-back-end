package com.controlstudy.basebackend.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "user", schema = "general")
public class User {
	
	@Id
	@Column(name = "idUser")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	// Constructor
	public User() {
		super();
	}
	
	// Getters and Setters
	
	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}