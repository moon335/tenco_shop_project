package com.tenco.tencoshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenco.tencoshop.repository.interfaces.UserRepository;
import com.tenco.tencoshop.repository.model.Product;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	// myinfo에서 주문한 제품 보기
	public List<Product> buyProductList(Integer userId) {

		List<Product> list = userRepository.buyList(userId);
		return list;
	}
	

}
