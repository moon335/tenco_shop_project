package com.tenco.tencoshop.dto;

import lombok.Data;

@Data
public class QuestionResponseDto {
	private String questionId;
	private String questionTitle;
	private String questionContent;
	private Integer questionUserId;
	private Integer questionReqStatus;
}
