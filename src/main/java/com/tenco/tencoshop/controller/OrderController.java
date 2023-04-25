package com.tenco.tencoshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@PostMapping("/purchase")
	public void purchase(Integer size, Integer prodId) {
		System.out.println(size);
		System.out.println(prodId);
	}
	
	
	
} // end of class
