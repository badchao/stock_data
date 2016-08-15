package com.github.stock_data.common.util;

import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {

	static ObjectMapper objectMapper = new ObjectMapper();
	
	public static String toJson(Object obj) {
		if(obj == null) return null;
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException("obj to json error,obj:"+obj,e);
		}
	}
	
}
