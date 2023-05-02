package com.tenco.tencoshop.repository.model;

import lombok.Data;

@Data
public class Notice {

	private Integer id;
	private String adminName;
	private String title;
	private String content;
	private Integer adminId;
	private Integer boardCategoryId;
	private String category;
}
