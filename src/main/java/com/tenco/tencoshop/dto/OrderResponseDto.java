package com.tenco.tencoshop.dto;

import lombok.Data;

@Data
public class OrderResponseDto {

	private Integer deliveryNonComplete;
	private Integer deliveryComplete;
	private Integer deliveryCount;

}
