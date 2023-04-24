package com.tenco.tencoshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenco.tencoshop.dto.UserInfoRequestDto;
import com.tenco.tencoshop.repository.interfaces.UserRepository;
import com.tenco.tencoshop.repository.model.Product;
import com.tenco.tencoshop.repository.model.User;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	// myinfo에서 주문한 제품 보기
	public List<Product> buyProductList(Integer userId) {

		List<Product> list = userRepository.buyList(userId);
		return list;
	}

	// myinfo에서 유저 정보 select하기
	public User userInfo(Integer userId) {
		userId = 1;
		User user = userRepository.userInfoSelect(userId);
		System.out.println("service" + user);
		return user;
	}

	// myinfo에서 유저정보 update하기
	public int userInfoUpdate(UserInfoRequestDto userInfoRequestDto, Integer principalId) {
		User user = new User();
		user.setEmail(userInfoRequestDto.getEmail());
		user.setPassword(userInfoRequestDto.getPassword());
		user.setLastName(userInfoRequestDto.getLastName());
		user.setTel(userInfoRequestDto.getTel());
		user.setId(1);
		int result = userRepository.userInfoUpdate(user);
		if(result !=1) {
			System.out.println("정보 수정에 실패하였습니다.");
		}
		return result;
	}

}
