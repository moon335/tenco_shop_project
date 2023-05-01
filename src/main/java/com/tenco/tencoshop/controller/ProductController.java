package com.tenco.tencoshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenco.tencoshop.dto.ProductResponseDto;
import com.tenco.tencoshop.repository.model.Product;
import com.tenco.tencoshop.repository.model.Size;
import com.tenco.tencoshop.service.ProductService;
import com.tenco.tencoshop.service.SizeService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private SizeService sizeService;

	// 검색 페이지
	// 파싱 기술

	@GetMapping("/search")
	public String search() {

		return "/product/search";
	}

	@GetMapping("/search-proc")
	public String searchProduct(@RequestParam(required = false) String title,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range, Model model) {
		List<Product> list = productService.searchProduct(title, begin, range);
		Double productCount = productService.productCount(title);
		Double count = Math.ceil(productCount);
		Integer page = (int) Math.ceil(count / 8);
		model.addAttribute("title", title);
		model.addAttribute("page", page);
		if (list.isEmpty()) {
			model.addAttribute("list", null);
		} else {
			model.addAttribute("list", list);
		}
		return "/product/searchProc";
	}

	@GetMapping("/prod-info/{id}")
	public String productPage(@PathVariable Integer id, Model model) {
		// 사이즈 정보 받아오기
		List<Size> sizeList = sizeService.readAllSize();
		// 상품 페이지로 넘길 정보 받아오기
		ProductResponseDto product = productService.readProductById(id);

		// 페이지로 데이터 넘기기
		model.addAttribute("product", product);
		model.addAttribute("sizeList", sizeList);

		return "/product/productDetail";
	}

	// 브랜드 전체 보기 페이지 들어가기
	@GetMapping("/brandPage")
	public String brandPage(Model model) {
		List<ProductResponseDto> brandList = productService.selectBrandAll();
		model.addAttribute("brandList", brandList);
		return "/user/brandPage";
	}

	// 브랜드 별 페이지 들어가기
	@GetMapping("/brandInfo")
	public String brandInfoPage(@RequestParam(required = false) Integer id,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range, Model model) {
		ProductResponseDto brand = productService.selectBrand(id);
		Double productCount = productService.selectBrandInfoCount(id);
		Double count = Math.ceil(productCount);
		Integer page = (int) Math.ceil(count / 8);
		model.addAttribute("id", id);
		model.addAttribute("page", page);
		List<ProductResponseDto> brandProductInfoList = productService.selectBrandInfo(id, begin, range);
		model.addAttribute("brand", brand);
		model.addAttribute("brandProductInfoList", brandProductInfoList);

		return "/user/brandInfoPage";
	}

}