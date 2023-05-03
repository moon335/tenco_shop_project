package com.tenco.tencoshop.dto;

import lombok.Data;

@Data
public class NoticeResponseDto {
	
	@Data
	public static class BoardTitleDto {
		private String title;
		private Integer id;
		private Integer boardCategoryId;
		private String categoryName;
	}
	
	@Data
	public static class NoticeContent{
		private String title;
		private Integer id;
		private String content;
	}
	
	@Data
	public static class faqDto{
		private Integer id;
		private String title;
		private String content;
		private String category;
	}

	private String adminName;
	private String title;
	private String content;
}
