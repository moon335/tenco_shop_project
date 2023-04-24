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
public class UserController {

	@Autowired // DI 처리
	private LoginService loginService;

	@Autowired
	private HttpSession session;

	@GetMapping("/myinfo")
	public String myInfo() {
		return "/user/myInfo";
	}

	@GetMapping("/help")
	public String help() {
		return "/user/help";
	}

	@GetMapping("/helpWriting")
	public String helpWriting() {
		return "/user/helpWriting";
	}

	@GetMapping("/myinfoEditor")
	public String myinfoEditor() {
		return "/user/myInfoEditor";
	}

	@GetMapping("/buy")
	public String buy() {
		return "/user/buy";
	}

	

}
