package com.tenco.tencoshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenco.tencoshop.dto.ProductResponseDto;
import com.tenco.tencoshop.repository.interfaces.ProductRepository;
import com.tenco.tencoshop.repository.model.Product;

@Service
public class ProductService {

	@Autowired // DI 의존 주입
	private ProductRepository productRepository;
	
	// 메인페이지용
	public List<ProductResponseDto> readAll() {
		List<ProductResponseDto> list = productRepository.findAllByMain();
		return list;
	}

	// 제품 카테고리 선택 시 상품 나열
	public List<ProductResponseDto> shopCategory(String name, Integer begin, Integer range) {
		name = "%" + name + "%";
		List<ProductResponseDto> list = productRepository.CategorySelect(name, begin, range);
		return list;
	}

	// 제품 카테고리 선택 시 상품 나열
	public Double shopCategoryCount(String name) {
		name = "%" + name + "%";
		Double selectCount = productRepository.CategorySelectCount(name);
		return selectCount;
	}

	public Double findAllCount() {
		Double findAllCount = productRepository.findAllCount();
		return findAllCount;
				
	}
	
	public List<ProductResponseDto> readProduct(Integer begin, Integer range) {
		List<ProductResponseDto> list = productRepository.findAll(begin,range);
		return list;
	}

	// 제품 검색 기능
	public List<Product> searchProduct(String title, Integer begin, Integer range) {
		title = "%" + title + "%";
		List<Product> list = productRepository.findProduct(title, begin, range);
		return list;
	}

	// 메인, 검색 페이지에서 사용
	public Product getProductInfo(Integer id) {
		Product prodInfo = productRepository.getProdInfo(id);
		return prodInfo;
	}

	// 제품 상세 페이지에서 사용
	public ProductResponseDto readProductById(Integer prodId) {
		ProductResponseDto responseProduct = productRepository.findProductByProdId(prodId);
		return responseProduct;
	}

	// 주문 페이지에서 사용 (상품 아이디와 사이즈 아이디로 상품 검색)
	public ProductResponseDto readProductByModelNumberAndSize(String modelNumber, String sizeName) {
		ProductResponseDto responseProduct = productRepository.findProductByModelNumberAndSize(modelNumber, sizeName);
		return responseProduct;
	}

	// 브랜드 모두 보기
	public List<ProductResponseDto> selectBrandAll() {
		List<ProductResponseDto> responseProductList = productRepository.selectBrandAll();
		return responseProductList;
	}

	// 브랜드 조회
	public ProductResponseDto selectBrand(Integer id) {
		ProductResponseDto responseProduct = productRepository.selectBrand(id);
		return responseProduct;
	}

	// 브랜드 별 상품 조회
	public List<ProductResponseDto> selectBrandInfo(Integer id, Integer begin, Integer range) {
		List<ProductResponseDto> brandProductInfo = productRepository.selectBrandInfo(id, begin, range);
		return brandProductInfo;
	}

	public Double selectBrandInfoCount(Integer id) {
		Double selectBrandInfoCount = productRepository.selectBrandInfoCount(id);
		return selectBrandInfoCount;
	}

	// 상품 갯수 구하기
	public Double productCount(String title) {
		title = "%" + title + "%";
		Double responseProductCount = productRepository.productCount(title);
		return responseProductCount;
	}

} // end of class
