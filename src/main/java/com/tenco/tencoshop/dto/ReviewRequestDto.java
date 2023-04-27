package com.tenco.tencoshop.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

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
	private String originFileName;

//	public String setUpReviewImage() {
//		return "/images/uploads/" + uploadFileName;
//	}
}
