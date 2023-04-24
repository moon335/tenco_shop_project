package com.tenco.tencoshop.dto;

import lombok.Data;

@Data
public class NoticeResponseDto {
	
	@Data
	public static class BoardTitleDto {
		private String title;
		private Integer id;
	}

	private String adminName;
	private String title;
	private String content;
}
