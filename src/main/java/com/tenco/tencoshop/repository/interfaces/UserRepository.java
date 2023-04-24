package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import com.tenco.tencoshop.repository.model.Product;
import com.tenco.tencoshop.repository.model.User;

public interface UserRepository {

	// 구매 목록 보기
	public List<Product> buyList(Integer userId);
	
	// 유저 정보 보기
	public User userInfoSelect(Integer userId);
	
}
