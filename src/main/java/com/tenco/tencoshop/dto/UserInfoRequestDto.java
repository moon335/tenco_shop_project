package com.tenco.tencoshop.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserInfoRequestDto {
	
	private String id;
	private String image;
	@Email(message = "이메일 형식이 아닙니다. ")
	private String email;
	@NotBlank(message = "비밀번호를 입력해주세요. ")
	private String password;
	@NotNull(message = "이름을 입력해 주세요. ")
	private String lastName;
	@NotNull(message = "전화번호를 입력해주세요. ")
	@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "전화번호는 010-0000-0000 형식으로 입력해야 합니다. ")
	private String tel;
	
	private MultipartFile file;
	private String originFileName;
	private String uploadFileName;
	
	public String setUpUserImage() {
		return uploadFileName == null ? "/images/myinfo.png" : "/images/uploads/" + uploadFileName;
	}
}
