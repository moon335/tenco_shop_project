package com.tenco.tencoshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		List<Product> list = productService.readProduct();
		model.addAttribute("list", list);
		return "layout/main";
	}

	// 검색 페이지
	// 파싱 기술

	@GetMapping("/search")
	public String search() {

		return "/user/search";
	}

	@GetMapping("/search-proc")
	public String searchProduct(@RequestParam String title, Model model) {
		List<Product> list = productService.searchProduct(title);
		if (list.isEmpty()) {
			model.addAttribute("list", null);
		} else {
			model.addAttribute("list", list);
		}
		return "/user/searchProc";
	}

}