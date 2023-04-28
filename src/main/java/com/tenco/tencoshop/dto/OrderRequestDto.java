package com.tenco.tencoshop.dto;

import lombok.Data;

@Data
public class OrderRequestDto {
	
	private String receiver;
	private String address;
	private String receiverPhoneNumber;
	private Integer prodId;
	private Integer cartId;
	private Integer userId;
	private String modelNumber;
	
} // end of class
