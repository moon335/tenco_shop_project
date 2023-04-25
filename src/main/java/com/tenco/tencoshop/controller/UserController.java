package com.tenco.tencoshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenco.tencoshop.dto.JoinResponseDto;
import com.tenco.tencoshop.dto.LoginResponseDto;
import com.tenco.tencoshop.handler.LoginException;
import com.tenco.tencoshop.repository.model.Product;
import com.tenco.tencoshop.repository.model.User;
import com.tenco.tencoshop.service.LoginService;
import com.tenco.tencoshop.service.UserService;
import com.tenco.tencoshop.util.Define;

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
		User user = userService.userInfo(userId);
		List<Product> orderList = userService.buyProductList(userId);
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

	@GetMapping("/sign-in")
	public String signIn() {

		return "user/login";
	}

	@PostMapping("/sign-in")
	public String signInProc(LoginResponseDto loginResponseDto) {

		if (loginResponseDto.getUsername() == null || loginResponseDto.getUsername().isEmpty()) {
			throw new LoginException("아이디를 입력해주세요", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (loginResponseDto.getPassword() == null || loginResponseDto.getPassword().isEmpty()) {
			throw new LoginException("비밀번호를 입력해주세요", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LoginResponseDto principal = loginService.signIn(loginResponseDto);
		principal.setPassword(null);
		session.setAttribute(Define.PRINCIPAL, principal);
		return "/layout/main";
	}

	// 회원가입
	@GetMapping("/sign-up")
	public String signUp() {

		return "user/join";
	}

	@PostMapping("/sign-up")
	public String signUpProc(JoinResponseDto joinResponseDto) {

		if (joinResponseDto.getUsername() == null || joinResponseDto.getUsername().isEmpty()) {
			throw new LoginException("이메일 주소를 입력해주세요", HttpStatus.BAD_REQUEST);
		}
		if (joinResponseDto.getPassword() == null || joinResponseDto.getPassword().isEmpty()) {
			throw new LoginException("비밀번호를 입력해주세요", HttpStatus.BAD_REQUEST);
		}
		if (joinResponseDto.getTel() == null || joinResponseDto.getTel().isEmpty()) {
			throw new LoginException("전화번호를 입력해주세요", HttpStatus.BAD_REQUEST);
		}
		if (joinResponseDto.getAddress() == null || joinResponseDto.getAddress().isEmpty()) {
			throw new LoginException("주소를 입력해주세요", HttpStatus.BAD_REQUEST);
		}
		if (joinResponseDto.getEmail() == null || joinResponseDto.getEmail().isEmpty()) {
			throw new LoginException("이메일을 입력해주세요", HttpStatus.BAD_REQUEST);
		}
		if (joinResponseDto.getFirstName() == null || joinResponseDto.getFirstName().isEmpty()) {
			throw new LoginException("성을 입력해주세요", HttpStatus.BAD_REQUEST);
		}
		if (joinResponseDto.getLastName() == null || joinResponseDto.getLastName().isEmpty()) {
			throw new LoginException("이름을 입력해주세요", HttpStatus.BAD_REQUEST);
		}
		
		loginService.createUser(joinResponseDto);

		return "user/login";
	}
	
	@GetMapping("/withdraw")
	public String withDraw() {
		
		return "user/delete";
	}

	@PostMapping("/withdraw")
	public String withDrawProc(LoginResponseDto loginResponseDto) {
		
		LoginResponseDto principal = loginService.signIn(loginResponseDto);
		principal.setPassword(null);
		session.setAttribute(Define.PRINCIPAL, principal);
		
		return "/layout/main";
	}

	// 로그아웃
	@GetMapping("/logout")
	public String logout() {

		session.invalidate();

		return "/layout/main";

	}

}
