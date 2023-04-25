package com.tenco.tencoshop.dto;

import lombok.Data;

@Data
public class NoticeResponseDto {
	
	@Data
	public static class BoardTitleDto {
		private String title;
		private Integer id;
	}
	
	@Data
	public static class NoticeContent{
		private String title;
		private Integer id;
		private String content;
	}

	private String adminName;
	private String title;
	private String content;
}
