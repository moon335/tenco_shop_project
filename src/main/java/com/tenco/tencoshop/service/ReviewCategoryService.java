package com.tenco.tencoshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenco.tencoshop.repository.interfaces.ReviewCategoryRepository;
import com.tenco.tencoshop.repository.model.ReviewCategory;

@Service
public class ReviewCategoryService {

	@Autowired
	private ReviewCategoryRepository reviewCategoryRepository;
	
	// 리뷰 카테고리 테이블 불러오기
	public List<ReviewCategory> readCategorys(){
		List<ReviewCategory> list = reviewCategoryRepository.findAll();
		return list;
	}
	
}
