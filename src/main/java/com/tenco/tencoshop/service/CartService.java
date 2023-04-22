package com.tenco.tencoshop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.tencoshop.repository.model.Product;
import com.tenco.tencoshop.repository.model.SampleUser;

@Service // IoC
public class CartService {
	
	// 유저 아이디 기반으로 검색 기능
	// 장바구니에 담겨있는 해당 유저의 모든 상품 받아오기
	// 1. 컨트롤러에서 session에 담긴 아이디 값 받아오기
	// 2. 넘겨받은 아이디 기반으로 장바구니 목록 검색
	@Transactional
	public List<Product> readCartByUserId(SampleUser user) {
		
		return null;
	}
	
	// todo
	// 장바구니에서 주문 후 장바구니 내용 삭제 요청해줘야함
	
	
} // end of class
