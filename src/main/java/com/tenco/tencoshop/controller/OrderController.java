package com.tenco.tencoshop.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenco.tencoshop.dto.LoginResponseDto;
import com.tenco.tencoshop.dto.OrderRequestDto;
import com.tenco.tencoshop.dto.ProductResponseDto;
import com.tenco.tencoshop.repository.model.Cart;
import com.tenco.tencoshop.repository.model.User;
import com.tenco.tencoshop.service.CartService;
import com.tenco.tencoshop.service.OrderService;
import com.tenco.tencoshop.service.ProductService;
import com.tenco.tencoshop.service.UserService;
import com.tenco.tencoshop.util.Define;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/purchase")
	public String orderPage(HttpServletRequest request, Model model) {
		// 세션에서 아이디 가져오기
		LoginResponseDto principal = (LoginResponseDto)session.getAttribute(Define.PRINCIPAL);
		// 쿠키에서 구매자가 선택한 사이즈와 상품 가져오기
		String sizeName = "";
		String prodId = "";
		String modelNumber = "";
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("size")) {
					sizeName = c.getValue();
				} else if (c.getName().equals("product")) {
					prodId = c.getValue();
				} else if (c.getName().equals("modelNumber")) {
					modelNumber = c.getValue();
				}
			}
		}
		System.out.println(sizeName);
		System.out.println(prodId);
		System.out.println(modelNumber);
		User loginUser = userService.readUserByUsername(principal.getUsername());
		ProductResponseDto responseProduct = productService.readProductByModelNumberAndSize(modelNumber, sizeName);
		System.out.println(responseProduct);
		model.addAttribute("product", responseProduct);
		model.addAttribute("loginUser", loginUser);
			
		return "/product/order";
	}
	
	@GetMapping("/purchase/{cartId}")
	public String orderPage(@PathVariable Integer cartId, Model model) {
		Cart responseCart = cartService.readCartById(cartId);
		ProductResponseDto responseProduct = productService.readProductById(responseCart.getProdId());
		User responseUser = userService.readUserByUserId(responseCart.getUserId());
		model.addAttribute("cart", responseCart);
		model.addAttribute("product", responseProduct);
		model.addAttribute("loginUser", responseUser);
		
		return "/product/order";
	}
	
	@PostMapping("/purchase")
	public void purchase(Integer size, Integer prodId, String modelNumber, HttpServletResponse response) {
		Cookie sizeCookie = new Cookie("size", size + "");
		sizeCookie.setMaxAge(60 * 60); // 1시간 쿠키 유지
		Cookie prodCookie = new Cookie("product", prodId + "");
		prodCookie.setMaxAge(60 * 60); // 1시간 쿠키 유지
		Cookie modelNumCookie = new Cookie("modelNumber", modelNumber);
		prodCookie.setMaxAge(60 * 60); // 1시간 쿠키 유지
		response.addCookie(sizeCookie);
		response.addCookie(prodCookie);
		response.addCookie(modelNumCookie);
	}
	
	@PostMapping("/input-order")
	public String inputOrder(OrderRequestDto orderRequestDto) {
		LoginResponseDto principal = (LoginResponseDto)session.getAttribute(Define.PRINCIPAL);
		orderService.createOrder(orderRequestDto, principal.getUsername());
		return "redirect:/main";
	}
	
	// 구매 확정 기능 
	@GetMapping("/updateDeliveryStatus")
	public String updateDeliveryStatus(@RequestParam Integer id) {
		orderService.updateDeliveryStatus(id);
		return "redirect:/user/myinfoProc";
	}

	
} // end of class
