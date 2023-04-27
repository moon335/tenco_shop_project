package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.tencoshop.repository.model.ReviewCategory;

@Mapper
public interface ReviewCategoryRepository {
	
	// 리뷰 카테고리 전체 검색
	public List<ReviewCategory> findAll();
}
