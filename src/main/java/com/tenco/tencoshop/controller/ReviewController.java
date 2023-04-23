package com.tenco.tencoshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenco.tencoshop.dto.ReviewResponseDto;
import com.tenco.tencoshop.service.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	// 구매 내역에 있는 것만 리뷰 쓸 때 사용하기
	@Autowired
	private HttpSession session;
	
	// 리뷰 게시물 조회 기능 
	@GetMapping("/style")
	public String styleOrder(@RequestParam(name = "type", defaultValue = "orderByRecent", required = false) String type, Model model) {
		List<ReviewResponseDto> reviewList = reviewService.readReviewByType(type);
		model.addAttribute("reviewList", reviewList);
		
		return "/review/style";
	}
	
	// 리뷰 상세 페이지
	@GetMapping("/detail/{userId}")
	public String style(Model model, ReviewResponseDto reviewResponseDto,@PathVariable Integer userId) {
		ReviewResponseDto reviewDto = reviewService.findDetail(reviewResponseDto, userId);
		model.addAttribute("reviewDto", reviewDto);
		
		return "/review/detail";
	}
	
}