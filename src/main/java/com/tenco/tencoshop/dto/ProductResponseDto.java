package com.tenco.tencoshop.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ProductResponseDto {

	private Integer id;
	private String engName;
	private String korName;
	private Integer releasePrice;
	private String imgRoute;
	private String brandName;
}
