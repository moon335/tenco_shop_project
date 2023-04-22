package com.tenco.tencoshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenco.tencoshop.dto.CartResponseDto;
import com.tenco.tencoshop.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/list")
	public String cart(Model model) {
		
		// 인증 검사 필요
		
		// 서비스 부르기
		// todo
		// session 값에서 아이디 가져오는 것으로 변경 예정
		List<CartResponseDto> cartList = cartService.readCartByUserId(1);
		// 주문 목록 페이지로 넘기기
		model.addAttribute("cartList", cartList);
		return "/product/cart";
	}
	
	
	
} // end of class
