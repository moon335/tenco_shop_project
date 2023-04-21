package com.tenco.tencoshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/review")
public class ReviewController {

   // header.jsp a태그 STYLE에서 주소 변경함
   @GetMapping("/style")
   public String mainTest() {
      return "/review/style";
   }
   
}