package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.tencoshop.dto.CartResponseDto;
import com.tenco.tencoshop.repository.model.Cart;

@Mapper
public interface CartRepository {
	
	public List<CartResponseDto> findByUserId(Integer userId);
	
} // end of class
