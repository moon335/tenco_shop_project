package com.tenco.tencoshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@GetMapping("/prod-info/{id}")
	public String productPage(@PathVariable Integer id) {
		
		return "/product/productDetail";
	}
	
	
	
} // end of class
