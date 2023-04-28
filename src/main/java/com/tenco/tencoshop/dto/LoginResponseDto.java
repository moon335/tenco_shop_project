package com.tenco.tencoshop.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class LoginResponseDto {

	private int id;
	private String username;
	private String password;
	private String role;
	private String image; 
	private Integer withdraw;
	private MultipartFile file;
	private String originFileName;
	private String uploadFileName;

	public String setUpUserImage() {
		return uploadFileName == null ? "/images/myinfo.png" : "/images/uploads/" + uploadFileName;
	}

}
