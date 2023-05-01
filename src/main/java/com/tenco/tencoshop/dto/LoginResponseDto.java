package com.tenco.tencoshop.dto;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class LoginResponseDto {

	private int id;
	@NotNull(message = "아이디를 입력 해주세요.")
	private String username;
	@NotNull(message = "비밀번호를 입력 해주세요.")
	private String password;
	private String role;
	private String image; 
	private Integer withdraw;
	private MultipartFile file;
	private String originFileName;
	private String uploadFileName;
	private String name;

	public String setUpUserImage() {
		return uploadFileName == null ? "/images/myinfo.png" : "/images/uploads/" + uploadFileName;
	}

}
