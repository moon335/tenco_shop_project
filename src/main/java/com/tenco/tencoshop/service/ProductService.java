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
   
} // end of class
