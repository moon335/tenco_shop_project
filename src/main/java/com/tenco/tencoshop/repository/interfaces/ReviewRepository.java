package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tenco.tencoshop.dto.ReviewResponseDto;

@Mapper
public interface ReviewRepository {

   // 리뷰 전체 목록 
   // + 인기순, 최신순 기능 구현
   public List<ReviewResponseDto> findByType(String type);
   
   // 리뷰 상세 페이지
   public ReviewResponseDto findDetail(@Param("reviewResponseDto") ReviewResponseDto reviewResponseDto, @Param("userId")Integer userId);
   
   // 상품 카테고리 별 출력
   public List<ReviewResponseDto> findByProdCategoryId(@Param("reviewResponseDto") ReviewResponseDto reviewResponseDto, @Param("prodId")Integer prodId);
   
}
