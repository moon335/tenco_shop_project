package com.tenco.tencoshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.tencoshop.repository.interfaces.ProductRepository;
import com.tenco.tencoshop.repository.model.Product;

@Service
public class AdminService {

	@Autowired
	private ProductRepository productRepository ;

	// 판매목록 조회하기
	@Transactional
	public List<Product> findProductAll() {
		List<Product> salesList = productRepository.findProductAll();
		return salesList;
	}
}