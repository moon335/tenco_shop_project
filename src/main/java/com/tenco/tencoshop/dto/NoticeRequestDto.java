package com.tenco.tencoshop.dto;

import lombok.Data;

@Data
public class NoticeRequestDto {

	@Data
	public static class insertDto {
		private String title;
		private Integer id;
		private String content;
		private Integer boardCategoryId;
	}
	
	@Data
	public static class deleteDto {
		private Integer id;
	}
	
}
