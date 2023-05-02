package com.tenco.tencoshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenco.tencoshop.dto.BrandResponseDto;
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
			@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer begin,
			@RequestParam(required = false) Integer range, Model model) {
		List<ProductResponseDto> list = productService.searchProduct(title, begin, range);
		Double productCount = productService.readProductCount(title);
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
		model.addAttribute("page", page);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("title", title);
		model.addAttribute("page", page);
		if (list.isEmpty()) {
			model.addAttribute("list", null);
		} else {
			model.addAttribute("list", list);
		}
		return "/product/searchProc";
	}

	@GetMapping("/prod-info/{modelNumber}")
	public String productPage(@PathVariable String modelNumber, Model model) {
		// 상품 페이지로 넘길 정보 받아오기
		ProductResponseDto product = productService.readProductByModelNumber(modelNumber);

		// 사이즈 정보 받아오기
		List<Size> sizeList = sizeService.readAllSize(product.getSizeCategoryId());

		// 페이지로 데이터 넘기기
		model.addAttribute("product", product);
		model.addAttribute("sizeList", sizeList);

		return "/product/productDetail";
	}

	// 브랜드 전체 보기 페이지 들어가기
	@GetMapping("/brandPage")
	public String brandPage(@RequestParam(required = false) Integer currentPage,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range, Model model) {
		List<BrandResponseDto> brandList = productService.readBrandAll(begin, range);
		Double productCount = productService.readBrandAllCount();
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
		model.addAttribute("page", page);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
		model.addAttribute("brandList", brandList);
		return "/user/brandPage";
	}

	// 브랜드 별 페이지 들어가기
	@GetMapping("/brandInfo")
	public String brandInfoPage(@RequestParam(required = false) Integer id,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range, Model model) {
		ProductResponseDto brand = productService.readBrand(id);
		Double productCount = productService.readBrandInfoCount(id);
		Double count = Math.ceil(productCount);
		Integer page = (int) Math.ceil(count / 8);
		model.addAttribute("id", id);
		model.addAttribute("page", page);
		List<ProductResponseDto> brandProductInfoList = productService.readBrandInfo(id, begin, range);
		model.addAttribute("brand", brand);
		model.addAttribute("brandProductInfoList", brandProductInfoList);

		return "/user/brandInfoPage";
	}

}