package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tenco.tencoshop.dto.BrandResponseDto;
import com.tenco.tencoshop.dto.ProductResponseDto;
import com.tenco.tencoshop.dto.ProductResponseDtoForReview;
import com.tenco.tencoshop.repository.model.Product;

@Mapper
public interface ProductRepository {

	public List<ProductResponseDto> findAllByMain();

	public List<ProductResponseDto> findAll(@Param("begin") Integer begin, @Param("range") Integer range);

	public Double findAllCount();

	// 관리자 판매 상품 전체 보기
	public List<Product> findProductAll();

	public List<ProductResponseDto> findProduct(@Param("title") String title, @Param("begin") Integer begin,
			@Param("range") Integer range);

	public Product findProductByModelNumberAndSizeId(@Param("modelNumber") String modelNumber,
			@Param("sizeId") Integer sizeId);

	public ProductResponseDtoForReview findProductById(Integer id);

	public ProductResponseDto findProductByProdId(Integer id);

	public ProductResponseDto findProductByModelNumber(String modelNumber);

	// 제품 카테고리 선택 시 상품 나열
	public List<ProductResponseDto> findCategory(@Param("name") String name, @Param("begin") Integer begin,
			@Param("range") Integer range);

	public Double findCategoryCount(String name);

	public ProductResponseDto findProductByModelNumberAndSize(@Param("modelNumber") String modelNumber,
			@Param("sizeName") String sizeName);

	// 브랜드 전체 조회
	public List<BrandResponseDto> findBrandAll(@Param("begin") Integer begin, @Param("range") Integer range);

	// 브랜드 조회
	public ProductResponseDto findBrand(Integer id);

	// 브랜드 별 상품 조회
	public List<ProductResponseDto> findBrandInfo(@Param("id") Integer id, @Param("begin") Integer begin,
			@Param("range") Integer range);

	// 브랜드 별 상품 조회 카운터
	public Double findBrandInfoCount(Integer id);

	// 상품 갯수 구하기
	public Double findProductCount(String title);

	// 브랜드 전체 조회 카운터
	public Double findBrandAllCount();
}