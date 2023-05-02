package com.tenco.tencoshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.tencoshop.dto.OrderCompleteDto;
import com.tenco.tencoshop.dto.OrderRequestDto;
import com.tenco.tencoshop.repository.interfaces.CartRepository;
import com.tenco.tencoshop.repository.interfaces.OrderRepository;
import com.tenco.tencoshop.repository.interfaces.UserRepository;
import com.tenco.tencoshop.repository.model.Cart;
import com.tenco.tencoshop.repository.model.Order;
import com.tenco.tencoshop.repository.model.User;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CartRepository cartRepository;

	@Transactional
	public void createOrder(OrderRequestDto orderRequestDto, String username) {
		if (orderRequestDto.getCartId() != null) {
			Cart inputCart = cartRepository.findById(orderRequestDto.getCartId());
			User user = userRepository.findByUsername(username);
			int userId = user.getId();
			orderRequestDto.setCartId(inputCart.getId());
			orderRequestDto.setUserId(userId);
		} else {
			User user = userRepository.findByUsername(username);
			int userId = user.getId();
			orderRequestDto.setUserId(userId);
		}
		int resultRow = orderRepository.insertOrder(orderRequestDto);
		if (resultRow != 1) {
			System.out.println("구매 실패");
		}
	}

	/**
	 * 구매확정기능
	 * @param id
	 * @return
	 */
	@Transactional
	public int updateDeliveryStatus(Integer id) {
		int result = orderRepository.updateDeliveryStatus(id);
		if (result == 0) {
			System.out.println("구매 확정 실패 ");
		}
		return result;
	}
	
	@Transactional
	public Order readById(Integer id) {
		Order orderEntity = orderRepository.findById(id);
		return orderEntity;
	}

	// 구매 확인 페이지
	@Transactional
	public OrderCompleteDto readByUserIdLimitOne(Integer userId) {
		OrderCompleteDto orderEntity = orderRepository.findByUserIdLimitOne(userId);
		return orderEntity;
	}
	
} // end of class
