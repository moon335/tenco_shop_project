package com.tenco.tencoshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenco.tencoshop.dto.ProductResponseDto;
import com.tenco.tencoshop.service.ProductService;

@Controller
@RequestMapping("/")
@Validated
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
	// shop 페이지들어감 
	@GetMapping("/shop")
	public String shop(Model model) {
		List<ProductResponseDto> list = productService.readProduct();
		model.addAttribute("list", list);
		return "layout/shop";
	}

	// shop 에서 카테고리별 select기능 구현 
	@GetMapping("/shopCategorySelect")
	public String shopCategorySelect(Model model,@RequestParam(name = "type", defaultValue = "all", required = false) String type) {
		if (type.equals("all")) {
			List<ProductResponseDto> list = productService.readProduct();
			model.addAttribute("list", list);
		} else {
			List<ProductResponseDto> list = productService.shopCategory(type);
			model.addAttribute("list", list);
			System.out.println(list);
		}
		return "layout/shop";
	}

}
