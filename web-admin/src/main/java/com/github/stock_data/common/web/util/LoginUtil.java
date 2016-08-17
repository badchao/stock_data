package com.github.stock_data.common.web.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.StringUtils;

public class LoginUtil {

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
