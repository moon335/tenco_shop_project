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
	ProductRepository productRepository;

	// 제품 카테고리 선택 시 상품 나열
	public List<ProductResponseDto> shopCategory(String name) {
		name = "%" + name + "%";
		List<ProductResponseDto> list = productRepository.CategorySelect(name);
		return list;
	}

   public List<ProductResponseDto> readProduct() {
      List<ProductResponseDto> list =  productRepository.findAll();
      
      return list;
   }
   
   // 제품 검색 기능
   public List<Product> searchProduct(String title){
      title = "%"+title+"%";
      List<Product> list = productRepository.findProduct(title);
      return list;
   }
   
   
   // 메인, 검색 페이지에서 사용
   public Product getProductInfo(Integer id) {
      Product prodInfo = productRepository.getProdInfo(id);
      return prodInfo;
   }
   
   // 제품 상세 페이지에서 사용
   public ProductResponseDto readProductById(Integer prodId) {
	   ProductResponseDto responseProduct = productRepository.findProductById(prodId);
	   return responseProduct;
   }
   
   // 주문 페이지에서 사용 (상품 아이디와 사이즈 아이디로 상품 검색)
   public ProductResponseDto readProductByModelNumberAndSize(String modelNumber, String sizeName) {
	   ProductResponseDto responseProduct = productRepository.findProductByModelNumberAndSize(modelNumber, sizeName);
	   return responseProduct;
   }
   
} // end of class
