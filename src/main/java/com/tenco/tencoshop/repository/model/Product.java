package com.tenco.tencoshop.repository.model;

import lombok.Data;

@Data
public class Product {
   private Integer id;
   private String img;
   private String prodName;
   private String prodDescription;
}