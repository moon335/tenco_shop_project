package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tenco.tencoshop.repository.model.Liketo;

@Mapper
public interface LiketoRepository {

	// 좋아요 눌렀을 때
	public int insertByUserId(Liketo liketo);
	
	// 좋아요 취소했을 때
	public int deleteById(Integer id);
	
	// 전체 리뷰 중 좋아요 누른 리뷰만
	public List<Liketo> findByUserId(Integer userId);
	
	// 리뷰 상세 페이지에 들어갔을 때 해당 상세페이지 좋아요 누른 게시물만
	public Liketo findByUserIdAndReviewId(@Param("userId") Integer userId, @Param("reviewId") Integer reviewId);
	
}
