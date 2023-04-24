package com.tenco.tencoshop.repository.model;

import lombok.Data;

@Data
public class Question {

	private Integer id;
	private String title;
	private String content;
	private Integer userId;
	private Integer reqStatus;
}
