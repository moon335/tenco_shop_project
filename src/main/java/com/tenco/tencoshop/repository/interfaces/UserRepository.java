package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.tencoshop.repository.model.Product;

@Mapper
public interface UserRepository {
	 // 구매목록 보기 
	   public List<Product> buyList(Integer userId);
}
