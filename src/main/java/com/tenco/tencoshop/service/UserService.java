package com.tenco.tencoshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.tencoshop.dto.ProductRequestDto;
import com.tenco.tencoshop.dto.ProductResponseDto;
import com.tenco.tencoshop.dto.SearchBuyListResponseDto;
import com.tenco.tencoshop.dto.UserInfoRequestDto;
import com.tenco.tencoshop.repository.interfaces.UserRepository;
import com.tenco.tencoshop.repository.model.Product;
import com.tenco.tencoshop.repository.model.User;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	// myinfo에서 주문한 제품 보기
	@Transactional
	public List<ProductRequestDto> buyProductList(Integer userId) {

		List<ProductRequestDto> list = userRepository.buyList(userId);
		return list;
	}

	// 구매목록 조회하기
	@Transactional
	public List<ProductRequestDto> searchProductList(ProductRequestDto productRequestDto) {
		List<ProductRequestDto> searchList = userRepository.searchBuyList(productRequestDto);
		System.out.println("!@#@!#!@#!#"+searchList);
		return searchList;
	}

	// myinfo에서 유저 정보 select하기
	@Transactional
	public User userInfo(Integer userId) {
		User user = userRepository.userInfoSelect(userId);
		return user;
	}

	// myinfo에서 유저정보 update하기
	@Transactional
	public int userInfoUpdate(UserInfoRequestDto userInfoRequestDto, Integer principalId) {
		User user = new User();
		user.setEmail(userInfoRequestDto.getEmail());
		user.setPassword(userInfoRequestDto.getPassword());
		user.setLastName(userInfoRequestDto.getLastName());
		user.setTel(userInfoRequestDto.getTel());
		user.setId(1);
		int result = userRepository.userInfoUpdate(user);
		if (result != 1) {
			System.out.println("정보 수정에 실패하였습니다.");
		}
		return result;
	}

}
