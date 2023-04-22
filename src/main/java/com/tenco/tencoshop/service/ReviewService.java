package com.tenco.tencoshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenco.tencoshop.repository.interfaces.ReviewRepository;
import com.tenco.tencoshop.repository.model.Review;

@Service // 서비스는 서비스 ~
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	public List<Review> readReview(){
		List<Review> list = reviewRepository.findAll();
		return list;
	}
	
}
