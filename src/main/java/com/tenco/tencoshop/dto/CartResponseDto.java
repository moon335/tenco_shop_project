package com.tenco.tencoshop.dto;

import java.sql.Date;

import com.tenco.tencoshop.util.MoneyFormatUtil;

import lombok.Data;

@Data
public class CartResponseDto {
   
   private Integer id;
   private Integer prodId;
   private Integer userId;
   private String engName;
   private String korName;
   private Integer purchase;
   private String gender;
   private Date releaseDate;
   private String color;
   private Integer releasePrice;
   private String imgRoute;
   private String brandName;
   private String categoryName;
   private String sizeName;
   
   public String purchaseFormat() {
	   return MoneyFormatUtil.moneyFormat(purchase);
   }
   
} // end of class
