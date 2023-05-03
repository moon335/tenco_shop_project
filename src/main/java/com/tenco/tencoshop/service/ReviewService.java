package com.tenco.tencoshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.tencoshop.dto.ProductResponseDtoForReview;
import com.tenco.tencoshop.dto.ReviewRequestDto;
import com.tenco.tencoshop.dto.ReviewResponseDto;
import com.tenco.tencoshop.repository.interfaces.ProductRepository;
import com.tenco.tencoshop.repository.interfaces.ReviewRepository;
import com.tenco.tencoshop.repository.interfaces.UserRepository;
import com.tenco.tencoshop.repository.model.User;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UserRepository userRepository;

	// 최신순, 인기순 기능
	public List<ReviewResponseDto> readReviewByType(String type) {
		List<ReviewResponseDto> list = reviewRepository.findByType(type);
		return list;
	}

	// 리뷰 카테고리 아이디 기반 게시물 출력
	public List<ReviewResponseDto> readReviewByProdId(Integer reviewCategoryId) {
		List<ReviewResponseDto> list = reviewRepository.findByProdCategoryId(reviewCategoryId);
		return list;
	}

	// id 기반 상세 페이지 출력
	public ReviewResponseDto readDetailById(Integer id) {
		ReviewResponseDto reviewDto = reviewRepository.findDetailById(id);
		return reviewDto;
	}

	// userId 기반 리뷰 페이지 출력
	public ReviewResponseDto readReviewByUserId(Integer userId) {
		ReviewResponseDto reviewDto = reviewRepository.findReviewByUserId(userId);
		return reviewDto;
	}

	// 리뷰 작성 페이지에 넘길 상품 정보 조회 기능
	@Transactional
	public ProductResponseDtoForReview readByOrderId(Integer orderId) {
		Integer prodId = reviewRepository.findByOrderId(orderId);
		ProductResponseDtoForReview product = productRepository.findProductById(prodId);
		return product;
	}

	@Transactional
	public void createReview(String username, ReviewRequestDto reviewRequestDto) {
		User user = userRepository.findByUsername(username);
		reviewRequestDto.setUserId(user.getId());
		int resultCnt = reviewRepository.insertReview(reviewRequestDto);
		if (resultCnt != 1) {
			System.out.println("insert 실패");
		}
	}

	public List<ReviewResponseDto> findReviewByUsername(String userName) {
		List<ReviewResponseDto> list = reviewRepository.findReviewListByUserName(userName);

		return list;
	}

	// userName 기반 내 리뷰 확인하기
	@Transactional
	public List<ReviewResponseDto> findMyReviewByUserName(String userName) {

		List<ReviewResponseDto> list = reviewRepository.findMyReviewByUserName(userName);
		return list;
	}

	// 리뷰 삭제 기능
	public void deleteMyReviewById(Integer id) {
		int resultCnt = reviewRepository.deleteMyReviewById(id);

		if (resultCnt != 1) {
			System.out.println("리뷰 삭제 실패");
		}

	}

	@Transactional
	public void updateMyReviewById(Integer id, ReviewRequestDto reviewRequestDto) {
		int resultCnt = reviewRepository.updateMyReviewById(reviewRequestDto);

		if (resultCnt != 1) {
			System.out.println("리뷰 수정 실패");
		}
	}

}
