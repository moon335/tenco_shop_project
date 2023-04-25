package com.tenco.tencoshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenco.tencoshop.dto.ReviewResponseDto;
import com.tenco.tencoshop.repository.model.ReviewCategory;
import com.tenco.tencoshop.service.ProductService;
import com.tenco.tencoshop.service.ReviewCategoryService;
import com.tenco.tencoshop.service.ReviewService;
import com.tenco.tencoshop.util.Define;

@Controller
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	@Autowired
	private ReviewCategoryService reviewCategoryService;
	@Autowired
	private ProductService productService;

	// 구매 내역에 있는 것만 리뷰 쓸 때 사용하기
	@Autowired
	private HttpSession session;

	// 리뷰 게시물 조회 기능
	@GetMapping("/style")
	public String styleOrder(@RequestParam(name = "type", defaultValue = "orderByRecent", required = false) String type,
			Model model) {
		List<ReviewResponseDto> reviewList = reviewService.readReviewByType(type);
		List<ReviewCategory> reviewCategoryList = reviewCategoryService.readCategorys();

		// 리뷰 게시물 조회 기능
		model.addAttribute("reviewList", reviewList);
		// 리뷰 카테고리
		model.addAttribute("reviewCategoryList", reviewCategoryList);

		return "/review/style";
	}

	// 상품 카테고리 별 출력
	@GetMapping("/prod-category/{reviewCategoryId}")
	public String categoryProd(Model model, @PathVariable Integer reviewCategoryId) {
		List<ReviewResponseDto> reviewList = reviewService.readReviewByProdId(reviewCategoryId);
		List<ReviewCategory> reviewCategoryList = reviewCategoryService.readCategorys();

		model.addAttribute("reviewList", reviewList);
		model.addAttribute("reviewCategoryList", reviewCategoryList);

		return "/review/style";
	}

	// 리뷰 상세 페이지
	@GetMapping("/detail/{id}")
	public String style(Model model, @PathVariable Integer id) {
		List<ReviewCategory> reviewCategoryList = reviewCategoryService.readCategorys();

		ReviewResponseDto review = reviewService.readDetailById(id);
		model.addAttribute("reviewCategoryList", reviewCategoryList);
		model.addAttribute("review", review);

		// redirect 수정할 수도 있음.
		return "/review/detail";
	}

	// myInfo의 내 후기 기능
	// type ?
	// 물건을 하나도 안 산 고객의 리뷰 0
	// 물건을 하나 산 고객의 리뷰 1
	// 물건을 여러 개 산 고객의 리뷰 1++
	@GetMapping("/myReview/{userId}")
	public String myReview(Model model, @PathVariable Integer userId) {
		ReviewResponseDto review = reviewService.readReviewByUserId(userId);
		model.addAttribute("review", review);
		return "/review/myReview";
	}

	// myInfo의 후기 올리기 기능
	@GetMapping("/reviewInsert/{userId}")
	public String reviewInsert(Model model, @PathVariable Integer userId) {
		ReviewResponseDto review = reviewService.readReviewByUserId(userId);
		model.addAttribute("review", review);
		
		return "/review/reviewInsert";
	}
	
	@PostMapping("/reviewInsert-proc")
	public String reviewInsertProc() {
		
		return "";
	}

	
}