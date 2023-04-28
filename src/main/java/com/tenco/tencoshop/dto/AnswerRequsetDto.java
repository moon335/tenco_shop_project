package com.tenco.tencoshop.dto;

import lombok.Data;

@Data
public class AnswerRequsetDto {
	private int questionId;
	private int id;
	private int adminId;
	private String content;
}
