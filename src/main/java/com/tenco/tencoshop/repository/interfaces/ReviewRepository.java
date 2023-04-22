package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.tencoshop.repository.model.Review;

@Mapper
public interface ReviewRepository {

	// 리뷰 전체 목록 
	public List<Review> findAll();
	
}
