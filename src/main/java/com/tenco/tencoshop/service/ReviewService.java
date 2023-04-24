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

   @Transactional
   public List<ReviewResponseDto> readReviewByType(String type) {
      List<ReviewResponseDto> list = reviewRepository.findByType(type);
      return list;
   }

   public ReviewResponseDto findDetail(ReviewResponseDto reviewResponseDto, Integer userId) {
      ReviewResponseDto reviewDto = reviewRepository.findDetail(reviewResponseDto, userId);
      return reviewDto;
   }
   
   public List<ReviewResponseDto> readReviewByProdId(ReviewResponseDto reviewResponseDto, Integer prodId){
      List<ReviewResponseDto> list =  reviewRepository.findByProdCategoryId(reviewResponseDto, prodId);
      return list;
   }
}