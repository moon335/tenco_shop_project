package com.tenco.tencoshop.repository.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Order {
	
	private Integer id;
	private Integer userId;
	private Integer productId;
	private Integer cartId;
	private String receiver;
	private String address;
	private String receiverPhoneNumber;
	private Date orderDate;
	private Integer deliveryStatus;
	
}
