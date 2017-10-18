package com.github.stock_data.common.util;

import org.apache.commons.lang3.StringUtils;

public class NumberParser {

	public static double parseChineseNumber(String str) {
		if(StringUtils.isBlank(str)) {
			return 0;
		}
		
		String num = str.replace('亿', '.').replace('万', ' ').replace('元', ' ').trim();
		return Double.parseDouble(num);
	}
	
}
