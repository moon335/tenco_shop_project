package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.tencoshop.dto.ReviewResponseDto;

@Mapper
public interface ReviewRepository {

	// 리뷰 전체 목록
	// + 인기순, 최신순 기능 구현
	public List<ReviewResponseDto> findByType(String type);

	// 상품 카테고리 별 출력
	public List<ReviewResponseDto> findByProdCategoryId(Integer reviewCategoryId);

	// id 기반 리뷰 상세 페이지
	public ReviewResponseDto findDetailById(Integer id);
	
	// userId 기반 내 리뷰 페이지 -> principal로 수정 예정?
	public ReviewResponseDto findReviewByUserId(Integer userId);
	
}
