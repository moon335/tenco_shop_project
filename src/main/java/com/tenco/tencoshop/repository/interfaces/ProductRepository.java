package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.tencoshop.dto.ProductResponseDto;
import com.tenco.tencoshop.repository.model.Product;

@Mapper
public interface ProductRepository {

	public List<ProductResponseDto> findAll();

	public List<Product> findProduct(String title);

	public Product getProdInfo(Integer id);

	public ProductResponseDto findProductById(Integer id);
	
	// 제품 카테고리 선택 시 상품 나열
	public List<ProductResponseDto> CategorySelect(String name);
	
}