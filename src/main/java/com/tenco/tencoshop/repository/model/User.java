package com.tenco.tencoshop.repository.model;

import lombok.Data;

@Data
public class User {
	
	private Integer id;
	private String username;
	private String password;
	private String tel;
	private String address;
	private String email;
	private String role;
	private String firstName;
	private String lastName;
	private String image;
	
} // end of class
