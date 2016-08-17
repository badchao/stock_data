package com.github.stock_data.common.web.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.StringUtils;

public class SecurityUtil {

	private static String salt = "39fdW3kf@dj498WederFhueirHUFDEU4387SDKFJD232&334sdfhrtFD23129sd934234324kfdflk3498dfgvdfgf834jfde823kf982kdJdwsdkweijjjhfg8723JHdcjwe23lk34958fgef8435jf";

	public static String getMd5Password(String input) {
		if (StringUtils.isEmpty(input))
			return null;
		return DigestUtils.md5Hex(salt + input);
	}
	
	public static boolean hasLoginUser(HttpServletRequest request) {
		WebLoginUser u = getLoginUser(request);
		if(u == null) {
			return false;
		}else {
			return true;
		}
	}
	
	public static WebLoginUser getLoginUser(HttpServletRequest request) {
		WebLoginUser result = (WebLoginUser)request.getSession().getAttribute("LOGIN_USER");
		return result;
	}
	
	public static void setLoginUser(HttpServletRequest request,WebLoginUser user) {
		request.getSession().setAttribute("LOGIN_USER",user);
	}
	
}
