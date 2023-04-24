package com.tenco.tencoshop.dto;

import lombok.Data;

@Data
public class UserInfoRequestDto {
	private String email;
	private String password;
	private String lastName;
	private String tel;
}
