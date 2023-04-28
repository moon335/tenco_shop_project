package com.tenco.tencoshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenco.tencoshop.dto.OrderRequestDto;
import com.tenco.tencoshop.repository.interfaces.CartRepository;
import com.tenco.tencoshop.repository.interfaces.OrderRepository;
import com.tenco.tencoshop.repository.interfaces.UserRepository;
import com.tenco.tencoshop.repository.model.Cart;
import com.tenco.tencoshop.repository.model.User;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	public void createOrder(OrderRequestDto orderRequestDto, String username) {
		if(orderRequestDto.getCartId() != null) {
			Cart ipnutCart = cartRepository.findById(orderRequestDto.getCartId());
			User user = userRepository.findByUsername(username);
			int userId = user.getId();
			orderRequestDto.setCartId(ipnutCart.getId());
			orderRequestDto.setUserId(userId);
		} else {
			User user = userRepository.findByUsername(username);
			int userId = user.getId();
			orderRequestDto.setUserId(userId);
		}
		int resultRow = orderRepository.insertOrder(orderRequestDto);
		
		if(orderRequestDto.getCartId() != null) {
			cartRepository.delete(orderRequestDto.getCartId());
		}
		if(resultRow != 1) {
			System.out.println("구매 실패");
		}
	}
	
} // end of class
