package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tenco.tencoshop.dto.ProductResponseDto;
import com.tenco.tencoshop.dto.ProductResponseDtoForReview;
import com.tenco.tencoshop.repository.model.Product;

@Mapper
public interface ProductRepository {

	public List<ProductResponseDto> findAll(@Param("begin") Integer begin,
			@Param("range") Integer range);

	public Double findAllCount();
	// 관리작 판매 상품 전체 보기
	public List<Product> findProductAll();

	public List<Product> findProduct(@Param("title") String title, @Param("begin") Integer begin,
			@Param("range") Integer range);

	public Product getProdInfo(Integer id);

	public ProductResponseDtoForReview findProductById(Integer id);

	public ProductResponseDto findProductByProdId(Integer id);

	// 제품 카테고리 선택 시 상품 나열
	public List<ProductResponseDto> CategorySelect(@Param("name") String name, @Param("begin") Integer begin,
			@Param("range") Integer range);

	public Double CategorySelectCount(String name);

	public ProductResponseDto findProductByModelNumberAndSize(@Param("modelNumber") String modelNumber,
			@Param("sizeName") String sizeName);

	// 브랜드 전체 조회
	public List<ProductResponseDto> selectBrandAll();

	// 브랜드 조회
	public ProductResponseDto selectBrand(Integer id);

	// 브랜드 별 상품 조회
	public List<ProductResponseDto> selectBrandInfo(@Param("id") Integer id, @Param("begin") Integer begin,
			@Param("range") Integer range);

	// 브랜드 별 상품 조회 카운터
	public Double selectBrandInfoCount(Integer id);

	// 상품 갯수 구하기
	public Double productCount(String title);
}