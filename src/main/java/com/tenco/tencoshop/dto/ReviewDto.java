package com.tenco.tencoshop.dto;

import lombok.Data;

@Data
public class ReviewDto {

	private Integer id;
	private String content;
	private String reviewImg;
	private Integer userId;
	private Integer prodId;
	
}
