package com.tenco.tencoshop.repository.interfaces;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.tencoshop.dto.OrderRequestDto;

@Mapper
public interface OrderRepository {
	
	public int insertOrder(OrderRequestDto orderRequestDto);
	
} // end of class
