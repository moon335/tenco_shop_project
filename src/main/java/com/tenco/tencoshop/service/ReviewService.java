package com.tenco.tencoshop.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tenco.tencoshop.dto.ProductResponseDto;
import com.tenco.tencoshop.dto.ReviewRequestDto;
import com.tenco.tencoshop.dto.ReviewResponseDto;
import com.tenco.tencoshop.repository.interfaces.ProductRepository;
import com.tenco.tencoshop.repository.interfaces.ReviewRepository;
import com.tenco.tencoshop.repository.interfaces.UserRepository;
import com.tenco.tencoshop.repository.model.Review;
import com.tenco.tencoshop.repository.model.ReviewCategory;
import com.tenco.tencoshop.repository.model.User;

@Service // 서비스는 서비스 ~ ㅎㅎ
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UserRepository userRepository;

	// 최신순, 인기순 기능
	@Transactional
	public List<ReviewResponseDto> readReviewByType(String type) {
		List<ReviewResponseDto> list = reviewRepository.findByType(type);
		return list;
	}

	// 리뷰 카테고리 아이디 기반 게시물 출력
	@Transactional
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
	public ProductResponseDto readByOrderId(Integer orderId) {
		Integer prodId = reviewRepository.findByOrderId(orderId);
		ProductResponseDto product = productRepository.findProductById(prodId);
		return product;
	}

	// 리뷰 작성 로직 구현
	// 1. username으로 userId 조회

	// 2. orderId 사용해서 prodId 가져오기

	// 3. select box에서 카테고리 선택 후 조건을 name으로 id 조회

	// 4. review_tb insert 작업 -> coment, review_img, 1번에서 가져온 userId, 2번에서
	// 가져온 prodId(order_tb -> join으로 cartId 하면 -> prodId가 있음)
	// reviewService.createReview(String coment, String review_img, int userId, int
	// prodId, int review_category_id)
	@Transactional
	public void createReview(String username, ReviewRequestDto reviewRequestDto) {
		// 1. username으로 userId 조회
		User user = userRepository.findByUsername(username);
		reviewRequestDto.setUserId(user.getId());

		// 4. insert 진행
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

	// 리뷰 수정 기능
	// id로 select 하고
//	 update처리 해야 됨?
	@Transactional
	public void updateMyReviewById(Integer id, ReviewRequestDto reviewRequestDto) {

		int resultCnt = reviewRepository.updateMyReviewById(reviewRequestDto);

		if (resultCnt != 1) {
			System.out.println("리뷰 수정 실패");
		}
	}

}
