package com.tenco.tencoshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenco.tencoshop.dto.ProductResponseDto;
import com.tenco.tencoshop.repository.model.Product;
import com.tenco.tencoshop.repository.model.Size;
import com.tenco.tencoshop.service.ProductService;
import com.tenco.tencoshop.service.SizeService;

@Controller
@RequestMapping("/product")
public class ProductController {

   @Autowired
   private ProductService productService;
   
   @Autowired
   private SizeService sizeService;

   // 검색 페이지
   // 파싱 기술

   @GetMapping("/search")
   public String search() {

      return "/product/search";
   }

   @GetMapping("/search-proc")
   public String searchProduct(@RequestParam String title, Model model) {
      List<Product> list = productService.searchProduct(title);
      if (list.isEmpty()) {
         model.addAttribute("list", null);
      } else {
         model.addAttribute("list", list);
      }
      return "/product/searchProc";
   }

   @GetMapping("/prod-info/{id}")
   public String productPage(@PathVariable Integer id, Model model) {
	  // 사이즈 정보 받아오기
	  List<Size> sizeList = sizeService.readAllSize();
	  // 상품 페이지로 넘길 정보 받아오기
      ProductResponseDto product = productService.readProductById(id);
      
      // 페이지로 데이터 넘기기
      model.addAttribute("product", product);
      model.addAttribute("sizeList", sizeList);
      
      return "/product/productDetail";
   }

}