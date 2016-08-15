package com.github.stock_data.common.util;

import java.util.HashMap;
import java.util.Map;

public class PlainMapUtil {

	/**
	 * 将map里面包含的map展开
	 * @param map
	 * @return
	 */
	public static Map<String,Object> toPlainMap(Map<String, Object> map) {
		Map<String,Object> resultMap = new HashMap();
		for(Map.Entry<String,Object> entry : map.entrySet()) {
			String key = entry.getKey();
			Object val = entry.getValue();
			if(val instanceof Map) {
				resultMap.putAll(toPlainMap((Map)val));
			}else {
				resultMap.put(key, val);
			}
		}
		return resultMap;
	}
}