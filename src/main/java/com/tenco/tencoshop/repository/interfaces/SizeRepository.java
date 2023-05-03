package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.tencoshop.repository.model.Size;

@Mapper
public interface SizeRepository {
	
	// 모든 사이즈 조회
	public List<Size> findAll(Integer sizeCategoryId);
	// id 기반 사이즈 조회
	public Size findByName(String size);
	
} 
