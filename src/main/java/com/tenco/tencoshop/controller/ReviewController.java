package com.tenco.tencoshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenco.tencoshop.repository.model.Review;
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
	public String style(Model model) {
		List<Review> reviewList = reviewService.readReview();
		model.addAttribute("reviewList", reviewList);
		
		return "/review/style";
	}

	// 리뷰 게시물 작성 페이지로 넘어감.
	@GetMapping("/insert")
	public String insert() {
		return "/review/insert";
	}
}