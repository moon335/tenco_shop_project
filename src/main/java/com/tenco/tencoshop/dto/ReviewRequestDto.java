package com.tenco.tencoshop.dto;


import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Valid
@Data
public class ReviewRequestDto {

	private Integer id;
	private String title;
	private String content;
	private Integer prodId;
	private Integer userId;
	private Integer orderId;
	private Integer reviewCategoryId;
	
	private MultipartFile file;
	private String uploadFileName;
	@NotNull
	@NotEmpty
	private String originFileName;

//	public String setUpReviewImage() {
//		return "/images/uploads/" + uploadFileName;
//	}
}
