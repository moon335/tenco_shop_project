package com.tenco.tencoshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@GetMapping("/purchase")
	public String orderPage() {
		return "/product/order";
	}
	
	@PostMapping("/purchase")
	public void purchase(Integer size, Integer prodId) {
		System.out.println(size);
		System.out.println(prodId);
	}
	
} // end of class
