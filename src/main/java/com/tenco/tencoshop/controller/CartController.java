package com.tenco.tencoshop.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenco.tencoshop.dto.CartResponseDto;
import com.tenco.tencoshop.dto.LoginResponseDto;
import com.tenco.tencoshop.repository.model.User;
import com.tenco.tencoshop.service.CartService;
import com.tenco.tencoshop.service.UserService;
import com.tenco.tencoshop.util.Define;

/**
 * 장바구니 관련 컨트롤러
 * @author 현우
 */

@Controller
@RequestMapping("/cart")
@Validated
public class CartController {
   
   @Autowired
   private CartService cartService;
   
   @Autowired
   private UserService userService;
   
   @Autowired
   private HttpSession session;

   /**
    * @param model
    * @return 장바구니 페이지
    */
   @GetMapping("/list")
   public String cart(Model model) {
      
	   LoginResponseDto principal = (LoginResponseDto)session.getAttribute(Define.PRINCIPAL);
	   User loginUser = userService.readUserByUsername(principal.getUsername());
      // 서비스 부르기
      List<CartResponseDto> cartList = cartService.readCartByUserId(loginUser.getId());
      // 주문 목록 페이지로 넘기기
      model.addAttribute("cartList", cartList);
      model.addAttribute("user", loginUser);
      return "/product/cart";
   }
   
   @PostMapping("/addCart")
   public String addCart(String size, String modelNumber) {
	   // 세션에서 로그인 유저 정보 받아와서 처리
	   LoginResponseDto principal = (LoginResponseDto)session.getAttribute(Define.PRINCIPAL);
	   // 서비스 불러서 insert 처리
	   cartService.createCart(size, modelNumber, principal.getUsername());
	   
	   return "/cart/list";
   }
   
   @GetMapping("/delete/{cartId}")
   public String deleteOne(@PathVariable Integer cartId) {
	   // 삭제 처리
	   cartService.deleteCart(cartId);
	   return "redirect:/cart/list";
   }
   
} // end of class
	
