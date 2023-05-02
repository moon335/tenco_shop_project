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
	private ProductService productService;

	@GetMapping("/main")
	public String mainTest(Model model) {
		List<ProductResponseDto> list = productService.readAll();
		model.addAttribute("list", list);
		return "layout/main";
	}

	// shop 페이지들어감
	@GetMapping("/shop")
	public String shop(@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range,
			Model model) {
		List<ProductResponseDto> list = productService.readProduct(begin, range);
		model.addAttribute("list", list);
		return "layout/shop";
	}

	// shop 에서 카테고리별 select기능 구현
	@GetMapping("/shopCategorySelect")
	public String shopCategorySelect(@RequestParam(required = false) Integer currentPage,
			@RequestParam(name = "type", defaultValue = "", required = false) String type,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range, Model model) {
		Double productCount = productService.shopCategoryCount(type);
		Double count = Math.ceil(productCount);
		Integer page = (int) Math.ceil(count / 8);
		Integer startPage = currentPage - 5;
		if (startPage <= 0) {
			startPage = 1;
		}
		Integer endPage = startPage + 9;
		if (endPage >= page) {
			endPage = page;
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("type", type);
		model.addAttribute("page", page);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		if (type.equals("all")) {
			List<ProductResponseDto> list = productService.readProduct(begin, range);
			model.addAttribute("list", list);
		} else {
			List<ProductResponseDto> list = productService.shopCategory(type, begin, range);
			model.addAttribute("list", list);
			System.out.println(list);
		}
		return "layout/shop";
	}

}
