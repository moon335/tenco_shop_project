package com.tenco.tencoshop.repository.model;

import lombok.Data;

@Data
public class Answer {

	private Integer id;
	private String content;
	private Integer questionId;
	private Integer adminId;
}
