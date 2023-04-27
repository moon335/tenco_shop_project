package com.tenco.tencoshop.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tenco.tencoshop.dto.CartResponseDto;
import com.tenco.tencoshop.repository.model.Cart;

@Mapper
public interface CartRepository {

	public List<CartResponseDto> findByUserId(Integer userId);
	public int insert(@Param("userId") Integer userId,@Param("prodId") Integer prodId,@Param("sizeId") Integer sizeId);
	public int delete(Integer cartId);
	public Cart findById(Integer cartId);

} // end of class
