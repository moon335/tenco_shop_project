package com.tenco.tencoshop.repository.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Product {

   private Integer id;
   private String engName;
   private String korName;
   private Integer purchase;
   private String gender;
   private Date releaseDate;
   private String color;
   private Integer releasePrice;
   private String imgRoute;
   private Integer brandId;
   private Integer categoryId;
   private Integer sizeId;
   private Integer sizeCategoryId;

   
} // end of class