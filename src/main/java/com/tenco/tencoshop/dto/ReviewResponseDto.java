package com.tenco.tencoshop.dto;

import lombok.Data;

@Data
public class ReviewResponseDto {

	private Integer id;
	private String content;
	private String reviewImg;
	private Integer userId;
	private Integer prodId;
	private Integer heart;
	private String userName;
	
}
