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
	private String imgRoute2;
	private String imgRoute3;
	private Integer brandId;
	private Integer categoryId;
	private Integer sizeId;
} // end of class