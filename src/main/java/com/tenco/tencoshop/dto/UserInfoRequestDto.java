package com.tenco.tencoshop.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserInfoRequestDto {
	private String id;
	private String image;
	private String email;
	private String password;
	private String lastName;
	private String tel;
	
	
	
	private MultipartFile file;
	private String originFileName;
	private String uploadFileName;
	
	public String setUpUserImage() {
		return uploadFileName == null ? "/images/myinfo.png" : "/images/uploads/" + uploadFileName;
	}
}
