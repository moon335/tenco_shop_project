package com.tenco.tencoshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenco.tencoshop.dto.LoginResponseDto;
import com.tenco.tencoshop.handler.LoginException;
import com.tenco.tencoshop.service.LoginService;

@Controller
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired // DI 처리
	private HttpSession session;
	
	@GetMapping("/sign-in")
	public String signIn() {
		
		return "user/login";
	}
	
	@PostMapping("/sign-in")
	public String signInProc(LoginResponseDto loginResponseDto) {
		
		// 유효성 검사
		if(loginResponseDto.getUsername() == null || loginResponseDto.getUsername().isEmpty()) {
			throw new LoginException("ID입력", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(loginResponseDto.getPassword() == null || loginResponseDto.getPassword().isEmpty()) {
			throw new LoginException("PW입력", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LoginResponseDto principal = loginService.signIn(loginResponseDto);
		principal.setPassword(null);
		session.setAttribute("principal", principal);
		// todo
		// 로그인 완료 후 화면
		return "/layout/main";
	}
	
	@GetMapping("/sign-up")
	public String signUp() {
		
		return "layout/signUp";
	}
	
	@PostMapping("/sign-up")
	public String signUpProc(LoginResponseDto loginResponseDto) {
		
		// 유효성 검사
		// id, pw null 값 확인
		
		if(loginResponseDto.getUsername() == null || loginResponseDto.getUsername().isEmpty()) {
			throw new LoginException("ID입력", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(loginResponseDto.getPassword() == null || loginResponseDto.getPassword().isEmpty()) {
			throw new LoginException("PW입력", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		LoginResponseDto principal = loginService.signIn(loginResponseDto);
		principal.setPassword(null);
		session.setAttribute("principal", principal);
		
		return "layout/main";
	}

}
