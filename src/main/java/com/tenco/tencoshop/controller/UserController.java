package com.tenco.tencoshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tenco.tencoshop.dto.ProductRequestDto;
import com.tenco.tencoshop.dto.ProductResponseDto;
import com.tenco.tencoshop.dto.SearchBuyListResponseDto;
import com.tenco.tencoshop.dto.UserInfoRequestDto;
import com.tenco.tencoshop.repository.model.Product;
import com.tenco.tencoshop.repository.model.User;
import com.tenco.tencoshop.service.UserService;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private HttpSession session;
	@Autowired
	private UserService userService;

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
}
