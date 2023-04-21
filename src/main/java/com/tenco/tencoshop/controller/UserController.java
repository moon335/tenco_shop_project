package com.tenco.tencoshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

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
