package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tenco.tencoshop.dto.ProductResponseDto;
import com.tenco.tencoshop.repository.model.Product;

@Mapper
public interface ProductRepository {

   public List<ProductResponseDto> findAll();
   public List<Product> findProduct(String title);
   public Product getProdInfo(Integer id);
   
   public ProductResponseDto findProductById(Integer id);
   
   public ProductResponseDto findProductByModelNumberAndSize(@Param("modelNumber") String modelNumber, @Param("sizeName") String sizeName);
  
}