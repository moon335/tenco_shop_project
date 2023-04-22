package com.tenco.tencoshop.repository.model;

import lombok.Data;

@Data
public class Review {

	private Integer id;
	private String content;
	private String review_img;
	private Integer user_id;
	private Integer prod_id;
	
}
