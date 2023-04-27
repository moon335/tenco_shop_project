package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.tencoshop.repository.model.Product;
import com.tenco.tencoshop.repository.model.User;

@Mapper
public interface UserRepository {
	// 구매목록 보기
	public List<Product> buyList(Integer userId);

	// 유저 정보 보기
	public User userInfoSelect(Integer userId);
	
	// username 기반 검색
	public User findByUsername(String username);
	
	public User findByUserId(Integer userId);
}