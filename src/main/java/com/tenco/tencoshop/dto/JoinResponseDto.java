package com.tenco.tencoshop.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class JoinResponseDto {

	@NotNull(message = "아이디를 입력 해주세요.")
	private String username;
	@NotNull(message = "비밀번호를 입력 해주세요.")
	private String password;
	@NotNull(message = "전화번호를 입력 해주세요.")
	@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "전화번호는 010-0000-0000 형식으로 입력해야 합니다.")
	private String tel;
	@NotNull(message = "주소를 입력 해주세요.")
	private String address;
	@NotNull(message = "이메일을 입력 해주세요.")
	@Email
	private String email;
	@NotNull(message = "성을 입력 해주세요.")
	private String firstName;
	@NotNull(message = "이름을 입력 해주세요.")
	private String lastName;
	private String role;

}