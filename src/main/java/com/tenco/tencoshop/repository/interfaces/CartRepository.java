package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.tencoshop.dto.CartResponseDto;

@Mapper
public interface CartRepository {

	public List<CartResponseDto> findByUserId(Integer userId);

} // end of class