package com.tenco.tencoshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.tencoshop.dto.CartResponseDto;
import com.tenco.tencoshop.repository.interfaces.CartRepository;
import com.tenco.tencoshop.repository.interfaces.ProductRepository;
import com.tenco.tencoshop.repository.interfaces.SizeRepository;
import com.tenco.tencoshop.repository.interfaces.UserRepository;
import com.tenco.tencoshop.repository.model.Cart;
import com.tenco.tencoshop.repository.model.Product;
import com.tenco.tencoshop.repository.model.Size;
import com.tenco.tencoshop.repository.model.User;

@Service // IoC
public class CartService {
   
   @Autowired
   private CartRepository cartRepository;
   
   @Autowired
   private ProductRepository productRepository;
   
   @Autowired
   private UserRepository userRepository;
   
   @Autowired
   private SizeRepository sizeRepository;
   
   @Transactional
   public List<CartResponseDto> readCartByUserId(Integer principalId) {
      
      List<CartResponseDto> cartList = cartRepository.findByUserId(principalId);
      
      return cartList;
   }
   
   @Transactional
   public void createCart(String size, String modelNumber, String username) {
	   
	 User targetUser = userRepository.findByUsername(username);
	 
	 Size targetSize = sizeRepository.findByName(size);
	 
	 Product targetProduct = productRepository.findProductByModelNumberAndSizeId(modelNumber, targetSize.getId());
	 
	 int resultRow = cartRepository.insert(targetUser.getId(), targetProduct.getId(), targetSize.getId());
	 if(resultRow != 1) {
		 System.out.println("장바구니 등록 실패");
	 }
   } 
   
   // 장바구니에서 삭제 처리
   @Transactional
   public void deleteCart(Integer cartId) {
	   int resultRow = cartRepository.delete(cartId);
	   if(resultRow != 1) {
		   System.out.println("장바구니 삭제 실패");
	   }
   }
   
   @Transactional
   public Cart readCartById(Integer cartId) {
	   Cart cart = cartRepository.findById(cartId);
	   return cart;
   }
   
} // end of class
