package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.tencoshop.repository.model.Product;

@Mapper
public interface ProductRepository {

   public List<Product> findAll();
   public List<Product> findProduct(String title);
}