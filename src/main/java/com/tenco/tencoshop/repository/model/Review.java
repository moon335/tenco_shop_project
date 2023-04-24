package com.tenco.tencoshop.repository.model;

import lombok.Data;

@Data
public class Review {

   private Integer id;
   private String content;
   private String reviewImg;
   private Integer userId;
   private Integer prodId;
   private Integer heart;
}
