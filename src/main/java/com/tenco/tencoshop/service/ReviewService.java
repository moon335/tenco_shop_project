package com.tenco.tencoshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.tencoshop.dto.ReviewResponseDto;
import com.tenco.tencoshop.repository.interfaces.ReviewRepository;

@Service // 서비스는 서비스 ~
public class ReviewService {

   @Autowired
   private ReviewRepository reviewRepository;

   // 최신순, 인기순 기능 
   @Transactional
   public List<ReviewResponseDto> readReviewByType(String type) {
      List<ReviewResponseDto> list = reviewRepository.findByType(type);
      return list;
   }

   // 리뷰 카테고리 아이디 기반 게시물 출력   
   @Transactional
   public List<ReviewResponseDto> readReviewByProdId(Integer reviewCategoryId){
      List<ReviewResponseDto> list =  reviewRepository.findByProdCategoryId(reviewCategoryId);
      return list;
   }
   
   // id 기반 상세 페이지 출력
   public ReviewResponseDto readDetailById(Integer id) {
	   ReviewResponseDto reviewDto = reviewRepository.findDetailById(id);
	   return reviewDto;
   }
   
   // userId 기반 리뷰 페이지 출력
   public ReviewResponseDto readReviewByUserId(Integer userId) {
	   ReviewResponseDto list = reviewRepository.findReviewByUserId(userId);
	   return list;
   }
}
