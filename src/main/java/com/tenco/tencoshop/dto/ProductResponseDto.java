package com.tenco.tencoshop.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ProductResponseDto {
   
   private Integer id;
   private String engName;
   private String korName;
   private Integer purchase;
   private String gender;
   private String modelNumber;
   private Date releaseDate;
   private String color;
   private Integer releasePrice;
   private String imgRoute;
   private String imgRoute2;
   private String imgRoute3;
   private Integer brandId;
   private Integer categoryId;
   private Integer sizeId;
   private String brandName;
   private String categoryName;
   private String sizename;
   
} // end of class
