package com.tenco.tencoshop.repository.interfaces;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.tencoshop.dto.OrderRequestDto;
import com.tenco.tencoshop.repository.model.Order;

@Mapper
public interface OrderRepository {
	
	public int insertOrder(OrderRequestDto orderRequestDto);
	public int updateDeliveryStatus(Integer id);
	public Order findById(Integer id);
	
} // end of class
