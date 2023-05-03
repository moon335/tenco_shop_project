package com.tenco.tencoshop.dto;


import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ReviewRequestDto {

	private Integer id;
	@NotNull(message = "제목을 입력 해주세요.")
	private String title;
	@NotNull(message = "내용을 입력 해주세요.")
	private String content;
	private Integer prodId;
	private Integer userId;
	private Integer orderId;
	private Integer reviewCategoryId;
	
	private MultipartFile file;
	private String uploadFileName;
	private String originFileName;

}
