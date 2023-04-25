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
import org.springframework.web.servlet.ModelAndView;

import com.tenco.tencoshop.dto.JoinResponseDto;
import com.tenco.tencoshop.dto.LoginResponseDto;
import com.tenco.tencoshop.dto.ProductRequestDto;
import com.tenco.tencoshop.dto.ProductResponseDto;
import com.tenco.tencoshop.dto.SearchBuyListResponseDto;
import com.tenco.tencoshop.dto.UserInfoRequestDto;
import com.tenco.tencoshop.handler.LoginException;
import com.tenco.tencoshop.repository.model.Product;
import com.tenco.tencoshop.repository.model.User;
import com.tenco.tencoshop.service.LoginService;
import com.tenco.tencoshop.service.UserService;
import com.tenco.tencoshop.util.Define;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private HttpSession session;
	@Autowired
	private UserService userService;
	@Autowired
	private LoginService loginService;

	// myinfo에서 주문한 제품 보기
	@GetMapping("/myinfoProc")
	public String myInfoProc(Integer userId, Model model) {
		userId = 1;
		User user = userService.userInfo(userId);
		List<ProductRequestDto> orderList = userService.buyProductList(userId);
		model.addAttribute("user", user);
		if (orderList.isEmpty()) {
			model.addAttribute("orderList", null);
		} else {
			model.addAttribute("orderList", orderList);
		}
		return "/user/myInfo";
	}

	// 구매목록화면 들어가기
	@GetMapping("buylist")
	public String buyList(Integer userId, Model model) {
		userId = 1;
		User user = userService.userInfo(userId);
		List<ProductRequestDto> orderList = userService.buyProductList(userId);
		model.addAttribute("user", user);
		if (orderList.isEmpty()) {
			model.addAttribute("orderList", null);
		} else {
			model.addAttribute("orderList", orderList);
		}
		return "/user/buy";

	}

	// 주문한 제품 search하기
	@GetMapping("/buylistProc")
	public String buyListProc(ProductRequestDto productRequestDto, Model model) {
		int userId = 1;
		productRequestDto.setUserId(userId);
		List<ProductRequestDto> orderList = userService.searchProductList(productRequestDto);
		System.out.println("orderList" + orderList);
		if (orderList.isEmpty()) {
			model.addAttribute("orderList", null);
		} else {
			model.addAttribute("orderList", orderList);
		}
		return "/user/buy";
	}

	// 질문 글쓰기
	@GetMapping("/questWriting")
	public String helpWriting() {
		return "/user/questWriting";
	}

	// 내 정보 수정 화면 들어가기
	@GetMapping("/myinfoEditor")
	public String myinfoEditor(Integer userId, Model model) {
		userId = 1;
		User user = userService.userInfo(userId);
		model.addAttribute("user", user);
		return "/user/myInfoEditor";
	}

	// 내 정보 수정하기
	@PostMapping("/myinfoupdate")
	public String myinfoUpdate(UserInfoRequestDto userInfoRequestDto) {
		userService.userInfoUpdate(userInfoRequestDto, 1);
		return "redirect:/user/myinfoEditor";
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

		return "/layout/main";
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
