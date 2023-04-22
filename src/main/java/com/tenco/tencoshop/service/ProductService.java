package com.tenco.tencoshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenco.tencoshop.repository.interfaces.ProductRepository;
import com.tenco.tencoshop.repository.model.Product;

@Service
public class ProductService {

   @Autowired // DI 의존 주입
   ProductRepository productRepository;

   public List<Product> readProduct() {
      List<Product> list =  productRepository.findAll();
      
      return list;
   }
   
   // 제품 검색 기능
   public List<Product> searchProduct(String title){
	   title = "%"+title+"%";
      List<Product> list = productRepository.findProduct(title);
      return list;
   }
}