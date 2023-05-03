package com.tenco.tencoshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.tencoshop.repository.interfaces.LiketoRepository;
import com.tenco.tencoshop.repository.interfaces.ReviewRepository;
import com.tenco.tencoshop.repository.model.Liketo;

@Service
public class LiketoService {

	@Autowired
	private LiketoRepository liketoRepository;
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Transactional
	public void createLiketoByUserId(Liketo liketo, String type) {
		Integer rowCount = liketoRepository.insertByUserId(liketo);
		Integer rowCount2 = reviewRepository.updateHeart(liketo.getReviewId(), type);
		
		if(rowCount != 1) {
			System.out.println("좋아요 insert 실패");
		}
		
		if(rowCount2 != 1) {
			System.out.println("좋아요 update 실패");
		}
	}
	
	@Transactional
	public void deleteById(Integer id, Integer reviewId, String type) {
		Integer rowCount = liketoRepository.deleteById(id);
		Integer rowCount2 = reviewRepository.updateHeart(reviewId, type);
		
		if(rowCount != 1) {
			System.out.println("좋아요 delete 실패");
		}
		
		if(rowCount2 != 1) {
			System.out.println("좋아요 update 실패");
		}
	}
	
	@Transactional
	public List<Liketo> readByUserId(Integer userId){
		List<Liketo> liketoList = liketoRepository.findByUserId(userId);
		return liketoList;
	}
	
	@Transactional
	public Liketo readByUserIdAndReviewId(Integer userId, Integer reviewId) {
		Liketo like2 = liketoRepository.findByUserIdAndReviewId(userId, reviewId);
		return like2;
	}
}
