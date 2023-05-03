package com.tenco.tencoshop.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ProductRequestDto {
	private Integer id;
	private Integer userId;
	private String engName;
	private String korName;
	private String username;
	private Integer purchase;
	private String modelNumber;
	private Date releaseDate;
	private String color;
	private Integer releasePrice;
	private String imgRoute;
	private Integer brandId;
	private Integer categoryId;
	private Integer sizeId;
	private String orderDate;
	private String orderStartDate;
	private String orderEndDate;
	private Integer deliveryStatus;
	private String sizeName;
	private Integer sizeCategoryId;
}
