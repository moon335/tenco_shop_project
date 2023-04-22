package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.tencoshop.repository.model.Product;

@Mapper
public interface CartRepository {
	
	public List<Product> findByUserId();
	
} // end of class
