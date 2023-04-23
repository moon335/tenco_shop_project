package com.tenco.tencoshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenco.tencoshop.dto.ProductResponseDto;
import com.tenco.tencoshop.service.ProductService;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	private HttpSession session;

	@Autowired
	private ProductService productService;

	@GetMapping("/main")
	public String mainTest(Model model) {
		List<ProductResponseDto> list = productService.readProduct();
		model.addAttribute("list", list);
		return "layout/main";
	}

	

}