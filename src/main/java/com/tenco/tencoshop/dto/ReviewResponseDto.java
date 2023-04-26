package com.tenco.tencoshop.dto;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tenco.tencoshop.util.TimestampUtil;

import lombok.Data;

// 페이지에 응답
@Data
public class ReviewResponseDto {

	private Integer id;
	private String title;
	private String content;
	private String reviewImg;
	private Integer userId;
	private Integer prodId;
	private Integer heart;
	private Timestamp createdAt;

	// user_tb
	private String userName;

	// review_category_tb
	private Integer reviewCategoryId;

	// join해서 들고올 product_tb의 상품 사진, 이름, 가격
	private String modelNumber;
	private String color;
	private String engName;
	private String korName;
	private String sizeName;
	private String brandName;

	// 파일 업로드 기능 ReviewFormDto 클래스를 하나 만들어야 할지 고민중
	private List<MultipartFile> files;
	private String originFileName;
	private String uploadFileName;

	public String formatCreatedAt() {
		return TimestampUtil.timestampToString(createdAt);
	}

}
