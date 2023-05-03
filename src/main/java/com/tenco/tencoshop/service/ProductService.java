package com.tenco.tencoshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.tencoshop.dto.BrandResponseDto;
import com.tenco.tencoshop.dto.ProductResponseDto;
import com.tenco.tencoshop.repository.interfaces.ProductRepository;
import com.tenco.tencoshop.repository.model.Product;

@Service
public class ProductService {

	@Autowired // DI 의존 주입
	ProductRepository productRepository;

	// 메인페이지용
	public List<ProductResponseDto> readAll() {
		List<ProductResponseDto> list = productRepository.findAllByMain();
		return list;
	}

	public Double findAllCount() {
		Double findAllCount = productRepository.findAllCount();
		return findAllCount;

	}

	// 제품 카테고리 선택 시 상품 나열
	@Transactional
	public List<ProductResponseDto> readShopCategory(String name, Integer begin, Integer range) {
		name = "%" + name + "%";
		List<ProductResponseDto> list = productRepository.findCategory(name, begin, range);
		return list;
	}

	// 제품 카테고리 선택 시 상품 나열
	@Transactional
	public Double readShopCategoryCount(String name) {
		name = "%" + name + "%";
		Double selectCount = productRepository.findCategoryCount(name);
		return selectCount;
	}

	public List<ProductResponseDto> readProduct(Integer begin, Integer range) {
		List<ProductResponseDto> list = productRepository.findAll(begin, range);
		return list;
	}

	// 제품 검색 기능
	@Transactional
	public List<ProductResponseDto> searchProduct(String title, Integer begin, Integer range) {
		title = "%" + title + "%";
		List<ProductResponseDto> list = productRepository.findProduct(title, begin, range);
		return list;
	}

	public ProductResponseDto readProductById(Integer prodId) {
		ProductResponseDto responseProduct = productRepository.findProductByProdId(prodId);
		return responseProduct;
	}

	// 제품 상세 페이지에서 사용
	public ProductResponseDto readProductByModelNumber(String modelNumber) {
		ProductResponseDto responseProduct = productRepository.findProductByModelNumber(modelNumber);
		return responseProduct;
	}

	// 주문 페이지에서 사용 (상품 아이디와 사이즈 아이디로 상품 검색)
	public ProductResponseDto readProductByModelNumberAndSize(String modelNumber, String sizeName) {
		ProductResponseDto responseProduct = productRepository.findProductByModelNumberAndSize(modelNumber, sizeName);
		return responseProduct;
	}

	// 브랜드 모두 보기
	public List<BrandResponseDto> readBrandAll(Integer begin, Integer range) {
		List<BrandResponseDto> responseProductList = productRepository.findBrandAll(begin, range);
		return responseProductList;
	}

	// 브랜드 조회
	public ProductResponseDto readBrand(Integer id) {
		ProductResponseDto responseProduct = productRepository.findBrand(id);
		return responseProduct;
	}

	// 브랜드 별 상품 조회
	public List<ProductResponseDto> readBrandInfo(Integer id, Integer begin, Integer range) {
		List<ProductResponseDto> brandProductInfo = productRepository.findBrandInfo(id, begin, range);
		return brandProductInfo;
	}

	public Double readBrandInfoCount(Integer id) {
		Double selectBrandInfoCount = productRepository.findBrandInfoCount(id);
		return selectBrandInfoCount;
	}

	// 상품 갯수 구하기
	@Transactional
	public Double readProductCount(String title) {
		title = "%" + title + "%";
		Double responseProductCount = productRepository.findProductCount(title);
		return responseProductCount;
	}

	// 브랜드 모두 보기 카운터
	public Double readBrandAllCount() {
		Double responseProductListCount = productRepository.findBrandAllCount();
		return responseProductListCount;
	}

} // end of class
