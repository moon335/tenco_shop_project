package com.tenco.tencoshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenco.tencoshop.dto.ProductResponseDto;
import com.tenco.tencoshop.repository.interfaces.ProductRepository;
import com.tenco.tencoshop.repository.model.Product;
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

	@GetMapping("/shop")
	public String shop(Model model) {
		List<ProductResponseDto> list = productService.readProduct();
		model.addAttribute("list", list);
		return "layout/shop";
	}

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
