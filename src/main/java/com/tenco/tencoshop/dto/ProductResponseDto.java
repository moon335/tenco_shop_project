package com.tenco.tencoshop.dto;

import java.sql.Date;

import com.tenco.tencoshop.util.MoneyFormatUtil;

import lombok.Data;

@Data
public class ProductResponseDto {

	private Integer id;
	private String engName;
	private String korName;
	private String modelNumber;
	private Integer purchase;
	private String gender;
	private Date releaseDate;
	private String color;
	private Integer releasePrice;
	private String imgRoute;
	private Integer brandId;
	private Integer categoryId;
	private Integer sizeId;
	private String brandName;
	private String categoryName;
	private String sizeName;
	private Double count;
	private Integer sizeCategoryId;
	private String sizeCategoryName;
	
	public String purchaseFormat() {
		   return MoneyFormatUtil.moneyFormat(purchase);
	   }

	public String releasePriceFormat() {
		return MoneyFormatUtil.moneyFormat(releasePrice);
	}
	
} // end of class
