package com.tenco.tencoshop.util;

import java.text.DecimalFormat;

public class MoneyFormatUtil {
	
	public static String moneyFormat(Integer money) {
		DecimalFormat df = new DecimalFormat("###,###");
		String formatNumber = df.format(money);
		return formatNumber;
	}
	
} // end of class
