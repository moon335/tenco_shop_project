package com.tenco.tencoshop.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenco.tencoshop.dto.LoginResponseDto;
import com.tenco.tencoshop.handler.LoginException;
import com.tenco.tencoshop.repository.model.Product;
import com.tenco.tencoshop.repository.model.User;
import com.tenco.tencoshop.service.LoginService;
import com.tenco.tencoshop.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired // DI 처리
	private LoginService loginService;
	
	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;

	@GetMapping("/myinfo")
	public String myInfo() {
		return "/user/myInfo";
	}

	@GetMapping("/myinfoProc")
	public String myInfoProc(Integer userId, Model model) {
		userId = 1;
		List<Product> orderList = userService.buyProductList(userId);
		System.out.println(orderList);
		if (orderList.isEmpty()) {
			model.addAttribute("orderList", null);
		} else {
			model.addAttribute("orderList", orderList);
		}
		return "/user/myInfo";
	}

	@GetMapping("/help")
	public String help() {
		return "/user/help";
	}

	@GetMapping("/questWriting")
	public String helpWriting() {
		return "/user/questWriting";
	}

	@GetMapping("/myinfoEditor")
	public String myinfoEditor(Integer userId, Model model) {
		userId = 1;
		User user = userService.userInfo(userId);
		model.addAttribute("user", user);
		System.out.println(user + "user");
		return "/user/myInfoEditor";
	}

	@GetMapping("/buy")
	public String buy() {
		return "/user/buy";
	}

	

}
