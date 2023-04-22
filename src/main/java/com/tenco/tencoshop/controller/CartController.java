package com.tenco.tencoshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@GetMapping("/list")
	public String cart() {
		
		// 인증 검사 필요
		
		// 주문 목록 페이지로 넘기기
		
		return "/product/cart";
	}
	
	
	
} // end of class
