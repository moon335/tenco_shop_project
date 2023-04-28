package com.tenco.tencoshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenco.tencoshop.repository.interfaces.SizeRepository;
import com.tenco.tencoshop.repository.model.Size;

@Service
public class SizeService {
	
	@Autowired
	private SizeRepository sizeRepository;
	
	public List<Size> readAllSize() {
		List<Size> sizeList = sizeRepository.findAll();
		return sizeList;
	}
	
} // end of class
