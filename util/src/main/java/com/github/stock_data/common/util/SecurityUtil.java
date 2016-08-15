package com.github.stock_data.common.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.StringUtils;

public class SecurityUtil {

	private static String salt = "39fdW3kf@dj498WederFhueirHUFDEU4387SDKFJD232&334sdfhrtFD23129sd934234324kfdflk3498dfgvdfgf834jfde823kf982kdJdwsdkweijjjhfg8723JHdcjwe23lk34958fgef8435jf";

	public static String getMd5Password(String input) {
		if (StringUtils.isEmpty(input))
			return null;
		return DigestUtils.md5Hex(salt + input);
	}
	
}
