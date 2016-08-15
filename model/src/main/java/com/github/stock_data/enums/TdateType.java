package com.github.stock_data.enums;

import com.github.rapid.common.lang.enums.EnumBase;

public enum TdateType implements EnumBase<String>{
	day("日"),
	week("周"),
	month("月"),
	quarter("季"),
	year("年"),
	;
	
	private final String desc;

	TdateType(String desc) {
		this.desc = desc;
	}
	
	
	@Override
	public String getCode() {
		return name();
	}

	@Override
	public String getDesc() {
		return desc;
	}

	
}
