package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tenco.tencoshop.dto.ProductResponseDto;
import com.tenco.tencoshop.dto.ProductResponseDtoForReview;
import com.tenco.tencoshop.repository.model.Product;

@Mapper
public interface ProductRepository {

	public List<ProductResponseDto> findAll();

	// 관리작 판매 상품 전체 보기
	public List<Product> findProductAll();

	public List<Product> findProduct(String title);

	public Product getProdInfo(Integer id);

	public ProductResponseDtoForReview findProductById(Integer id);
	
	public ProductResponseDto findProductByProdId(Integer id);

	// 제품 카테고리 선택 시 상품 나열
	public List<ProductResponseDto> CategorySelect(String name);

   
   public ProductResponseDto findProductByModelNumberAndSize(@Param("modelNumber") String modelNumber, @Param("sizeName") String sizeName);
  
   
   	// 브랜드 전체 조회 
	public List<ProductResponseDto> selectBrandAll();
	
	// 브랜드 조회
	public ProductResponseDto selectBrand(Integer id);
	
	public List<ProductResponseDto> selectBrandInfo(Integer id);
}