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
   
   // 유저 아이디 기반으로 검색 기능
   // 장바구니에 담겨있는 해당 유저의 모든 상품 받아오기
   // 1. 컨트롤러에서 session에 담긴 아이디 값 받아오기
   // 2. 넘겨받은 아이디 기반으로 장바구니 목록 검색
   @Transactional
   public List<CartResponseDto> readCartByUserId(Integer principalId) {
      
      List<CartResponseDto> cartList = cartRepository.findByUserId(principalId);
      
      return cartList;
   }
   
   // todo
   // 장바구니에서 주문 후 장바구니 내용 삭제 요청해줘야함
   
   // 상세 페이지에서 장바구니 담기를 눌렀을 때 테이블에 추가하기
   @Transactional
   public void createCart(String size, Integer prodId, String username) {
	   
	 User targetUser = userRepository.findByUsername(username);
	 
	 Size targetSize = sizeRepository.findByName(size);
	 
	 Product targetProduct = productRepository.getProdInfo(prodId);
	 
	 int resultRow = cartRepository.insert(targetUser.getId(), targetProduct.getId(), targetSize.getId());
	 if(resultRow != 1) {
		 System.out.println("장바구니 등록 실패");
	 }
   } 
   
   // 장바구니에서 삭제 처리
   public void deleteCart(Integer cartId) {
	   int resultRow = cartRepository.delete(cartId);
	   if(resultRow != 1) {
		   System.out.println("장바구니 삭제 실패");
	   }
   }
   
   public Cart readCartById(Integer cartId) {
	   Cart cart = cartRepository.findById(cartId);
	   return cart;
   }
   
   
} // end of class
