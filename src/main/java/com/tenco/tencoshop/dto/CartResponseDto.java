package com.tenco.tencoshop.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class CartResponseDto {
	
	private Integer id;
	private Integer amount;
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
	private String imgRoute2;
	private String imgRoute3;
	private String brandName;
	private String categoryName;
	private String sizeName;
	
} // end of class
