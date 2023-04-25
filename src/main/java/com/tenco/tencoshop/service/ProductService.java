package com.tenco.tencoshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenco.tencoshop.dto.ProductResponseDto;
import com.tenco.tencoshop.repository.interfaces.ProductRepository;
import com.tenco.tencoshop.repository.model.Product;

@Service
public class ProductService {

	// 메서드 이름 CRUD + 이름;
	
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
   
   
   // 제품 상세페이지로 넘기기 
   public Product getProductInfo(Integer id) {
      Product prodInfo = productRepository.getProdInfo(id);
      System.out.println(prodInfo);
      return prodInfo;
   }
   
   
   
}