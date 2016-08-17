package com.github.stock_data.tools;

import org.junit.Test;

import com.github.stock_data.common.web.util.LoginUtil;

public class SecurityUtilTest {

	@Test
	public void test() {
		String pwd = LoginUtil.getMd5Password("abc");
		System.out.println(pwd+" "+pwd.length());
	}

}
