package com.tenco.tencoshop.dto;

import java.sql.Date;

import com.tenco.tencoshop.util.MoneyFormatUtil;

import lombok.Data;

@Data
public class OrderCompleteDto {

	private String engName;
	private String korName;
	private String modelNumber;
	private Integer purchase;
	private String color;
	private String imgRoute;
	private String brandName;
	private String sizeName;
	private Date orderDate;

	public String purchaseFormat() {
		return MoneyFormatUtil.moneyFormat(purchase);
	}

}
