package com.tenco.tencoshop.dto;

import java.sql.Timestamp;

import com.tenco.tencoshop.util.TimestampUtil;

import lombok.Data;

// 페이지에 응답
@Data
public class ReviewResponseDto {

   private Integer id;
   private String content;
   private String reviewImg;
   private Integer userId;
   private Integer prodId;
   private Integer heart;
   private Timestamp createdAt;
   
   // user_tb
   private String userName;
   
   // review_category_tb
   private Integer reviewCategoryId;
   
   // join해서 들고올 product_tb의 상품 사진, 이름, 가격
   
   public String formatCreatedAt() {
	   return TimestampUtil.timestampToString(createdAt);
   }
   
}
